package br.com.pibicjoaomir.ferramentas;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ScriptCaller {
	
	private final static Logger logger = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );     
	
	@Async
	public void callScript(String nomeFerramenta, ArrayList<String> features
			, String dataBase, String email, String format) {
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
		try {
			String line = "python3 /home/joao/PycharmProjects/pibicjoaomir/executavel_"+
		nomeFerramenta+".py "+ dataBase+" ";
		    CommandLine cmdLine = CommandLine.parse(line);
		    cmdLine.addArgument(email);
		    cmdLine.addArgument(format);
		    for (String string : features) {
				cmdLine.addArgument(string);
			}
		    
		    DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

		    
		    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		    PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		        
		    DefaultExecutor executor = new DefaultExecutor();
		    executor.setStreamHandler(streamHandler);
		    executor.execute(cmdLine, resultHandler);
//		    executor.execute(cmdLine);
		    logger.info(cmdLine.toString());
		    logger.info("Saindo do ScriptCaller");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
