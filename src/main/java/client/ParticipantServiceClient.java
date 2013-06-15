package client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import acidoth.thrift.xa.AcidothParticipantXAServices;
import acidoth.thrift.xa.EndPointReference;
import acidoth.thrift.xa.PCResponse;

public class ParticipantServiceClient {

    String serverUrl;
    int port;
	
	public ParticipantServiceClient(String serverUrl, int port){
		this.serverUrl = serverUrl;
        this.port = port;
	}
	
	public PCResponse xa_commit(String identifier){
		
		TTransport transport;
		AcidothParticipantXAServices.Client commitClient;
		PCResponse pcResponse = null;
		
		transport = new TSocket(serverUrl, port);
		try {
			
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			commitClient = new AcidothParticipantXAServices.Client(protocol);
			
			pcResponse = commitClient.xa_commit(identifier);
			
			transport.close();
			
			}catch (TException e) {
				e.printStackTrace();			
		}
			return pcResponse;
	}
	
	public PCResponse xa_abort(String identifier){
		
		TTransport transport;
		AcidothParticipantXAServices.Client abortClient;
		PCResponse pcResponse = null;
		
		transport = new TSocket(serverUrl, port);
		try {
			
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			abortClient = new AcidothParticipantXAServices.Client(protocol);
			
			pcResponse = abortClient.xa_abort(identifier);
			
			transport.close();
			
			}catch (TException e) {
				e.printStackTrace();			
		}
			return pcResponse;
	}
	
	public PCResponse xa_rollback(String identifier){

		TTransport transport;
		AcidothParticipantXAServices.Client rollbackClient;
		PCResponse pcResponse = null;
		
		transport = new TSocket(serverUrl, port);
		try {
			
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			rollbackClient = new AcidothParticipantXAServices.Client(protocol);
			
			pcResponse = rollbackClient.xa_rollback(identifier);
			
			transport.close();
			
			}catch (TException e) {
				e.printStackTrace();			
		}
			return pcResponse;
	}
	
	public PCResponse xa_prepare(String identifier){

		TTransport transport;
		AcidothParticipantXAServices.Client prepareClient;
		PCResponse pcResponse = null;
		
		transport = new TSocket(serverUrl, port);
		try {
			
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			prepareClient = new AcidothParticipantXAServices.Client(protocol);
			
			pcResponse = prepareClient.xa_prepare(identifier);
			
			transport.close();
			
			}catch (TException e) {
				e.printStackTrace();			
		}
			return pcResponse;
	}
	
}

