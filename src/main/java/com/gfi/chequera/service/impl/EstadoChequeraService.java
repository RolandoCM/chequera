/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.gfi.chequera.converter.MovimientosConverter;
import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.model.EstadoChequera;
import com.gfi.chequera.model.MailModel;
import com.gfi.chequera.repository.MovimientosRepository;
import com.gfi.chequera.service.IEstadoChequeraService;
import com.lowagie.text.pdf.PdfWriter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 11/04/2018
 */
@Service
public class EstadoChequeraService implements IEstadoChequeraService{
	private final static Logger LOG = Logger.getLogger(EstadoChequeraService.class);
	@Autowired
	private MovimientosRepository movimientoRepository;
	@Autowired
	private MovimientosConverter movimientoConverter;
	@Autowired
	private MovimientosService movimientoService;
	@Autowired
	private ChequeraService chequeraService;
	@Autowired
	private SendMailService sendMail;
	@Override
	public Map<String, Object> estadoCuentaMes(int idChequera, String fechaInicio, String fechaCorte) {
		Map<String, Object> params = new HashMap<>();
		ChequeraModel chequeraModel = new ChequeraModel();
		List<EstadoChequera> listMovimientosModel = new ArrayList<>();
		chequeraModel = chequeraService.seachChequera(idChequera);
		//listMovimientosModel = movimientoService.listarMovimientos();
		listMovimientosModel = movimientoService.estadoChequera(fechaInicio, fechaCorte, idChequera);
		LOG.info("Size list ------"+listMovimientosModel.size());
		JRBeanCollectionDataSource movimientosDS = new JRBeanCollectionDataSource(listMovimientosModel);
		
		params.put("banco", chequeraModel.getBanco().getbNombre());
		params.put("chequera", Integer.toString(chequeraModel.getIdChequera()));
		params.put("cuenta", chequeraModel.getChNumCuenta());
		params.put("datasource", movimientosDS);
		params.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.FALSE);
		
		
		
		JasperPrint jasperPrint;
		String jasperFile = "src/main/resources/reports/estadoChequera.jasper";
		String jrxmlFile = "src/main/resources/reports/estadoChequera.jrxml";
		String pdfFile ="src/main/resources/reports/estadoChequera.pdf";
		try {
			
			InputStream report		  =new FileInputStream(jrxmlFile);
			JasperReport jasperReport =JasperCompileManager.compileReport(report);
			JRSaver.saveObject(jasperReport, jasperFile);
			jasperPrint = JasperFillManager.fillReport(jasperFile, params);
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfFile));
			SimplePdfReportConfiguration reportConfig
			  = new SimplePdfReportConfiguration();
			reportConfig.setSizePageToContent(true);
			reportConfig.setForceLineBreakPolicy(false);
			 
			SimplePdfExporterConfiguration exportConfig
			  = new SimplePdfExporterConfiguration();
			exportConfig.setMetadataAuthor("Rolando Castillo");
			exportConfig.setEncrypted(true);
			exportConfig.setAllowedPermissionsHint("PRINTING");
		
			 
			exporter.setConfiguration(reportConfig);
			exporter.setConfiguration(exportConfig);
			 
			exporter.exportReport();
			
			MailModel mail = new MailModel();
			
			mail.setFrom("no-reply@memorynotfound.com");
			mail.setTo(chequeraModel.getCliente().getcCorreo());
			mail.setSubject("Reporte");
			mail.setContent("Adjunto reporte");
			sendMail.sendMailMessage(mail, "reports/estadoChequera.pdf", "reporte.pdf");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return params;
	}

}
