package br.com.pibicjoaomir.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pibicjoaomir.ferramentas.ScriptCaller;

@Controller
public class HomeController {
	

	private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
	
	
	private long startTime = 0;
	private long endTime = 0;
	
	@RequestMapping("/home")
	public ModelAndView index() {
		LogManager.getLogManager().reset();
		logger.setLevel(Level.ALL);
		try {
            FileHandler fh = new FileHandler("logInfo.log", true);
            fh.setLevel(Level.FINE);
            logger.addHandler(fh);
        } catch (java.io.IOException e) {            
            // don't stop my program but log out to console.
        	logger.log(Level.SEVERE, "nao foi possivel abrir arquivo de log", e);
        }
		logger.info("entrando na home");
		startTime = System.nanoTime();
		
		ModelAndView modelAndView = new ModelAndView("home");
		ArrayList<String> ferramentas = new PropertieController().getToolNames();
		modelAndView.addObject("ferramenta", ferramentas);
		return modelAndView;
	}
	
	@RequestMapping("/ferramenta")
	public ModelAndView ferramentaSelecionada(String ferramenta){
		logger.info("entrando na /ferramenta");
		PropertieController propController = new PropertieController();
		propController.readProperties(ferramenta);
		ArrayList<String> props = propController.getPropList();
		ArrayList<String> dataBases = propController.getDataBaseList();
		ArrayList<String> formats = propController.getFormatList();
		ModelAndView modelAndView = new ModelAndView("listaDeFeatures");
		modelAndView.addObject("featuresList", props);
		modelAndView.addObject("toolName", ferramenta);
		modelAndView.addObject("dataBaseList",dataBases);
		modelAndView.addObject("formatList", formats);
		return modelAndView;
	}
	
	@RequestMapping("/features")
	public ModelAndView featuresSelecionadas(String[] featuresSelecionadas, String nomeFerramenta,String userEmail
			, String dataBaseSelecionada, String formatoSelecionado){
		logger.info("entrando na /features");
		PropertieController propController = new PropertieController();
		ArrayList<String> propValues = propController.getPropertieValues(featuresSelecionadas, nomeFerramenta);
		String dataBasePath = propController.getDatabasePath(dataBaseSelecionada, nomeFerramenta);
		String formatValue = propController.getFormatValue(formatoSelecionado, nomeFerramenta);
		ModelAndView modelAndView = new ModelAndView("confirmacao");
		modelAndView.addObject("features",featuresSelecionadas);
		modelAndView.addObject("ferramenta", nomeFerramenta);
		modelAndView.addObject("email", userEmail);
		modelAndView.addObject("dataBase", dataBaseSelecionada);
		modelAndView.addObject("formato", formatoSelecionado);
		logger.info("entrando no script caller");
		ScriptCaller scriptCaller = new ScriptCaller();
		scriptCaller.callScript(nomeFerramenta, propValues, dataBasePath, userEmail, formatValue);
		System.out.println("Email:"+userEmail);
		for (String string : propValues) {
			System.out.println(string);
		}
		System.out.println("nome da ferramenta: "+nomeFerramenta);
		System.out.println("dataBase: "+dataBasePath);
		System.out.println("Valores Properties: "+propValues);
		endTime = System.nanoTime();
		System.out.println("Tempo execucao: " + (endTime - startTime));
		return modelAndView;
	}
	
	public static void main(String[] args){
		try {
			System.out.println("teste");
			String s = null;
			Process p = Runtime.getRuntime().exec("python C:\\Users\\joaof\\Desktop\\DevTools\\forge\\bin\\pibicjoaomir\\teste_pythohn\\teste.py 1 2");
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((s = in.readLine()) != null) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
