package server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import acidoth.thrift.xa.AcidothCoordinatorXAServices;

public class CoordinationXAServer {

	public static void startServer(AcidothCoordinatorXAServices.Processor<CoordinatorServiceHandler> processor){
		
try {
			
			TServerTransport serverTransport = new TServerSocket(9090);
			TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
			
			System.out.println("Starting Server...");
			
			server.serve();
			
		} catch (TTransportException e) {
			System.out.println("Could not Start the Server...");
		}
	}
	
	public static void main(String[] args){
		startServer(new AcidothCoordinatorXAServices.Processor<CoordinatorServiceHandler>(new CoordinatorServiceHandler()));
	}
}
