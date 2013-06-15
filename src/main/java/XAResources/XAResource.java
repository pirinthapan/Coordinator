package XAResources;

import acidoth.thrift.xa.EndPointReference;
import acidoth.thrift.xa.PCResponse;
import client.ParticipantServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.xa.XAException;
import javax.transaction.xa.Xid;

/**
 * Created with IntelliJ IDEA.
 * User: pirinthapan
 * Date: 6/13/13
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class XAResource implements javax.transaction.xa.XAResource {

    ParticipantServiceClient participantServiceClient;

    public XAResource(EndPointReference endPointReference){
        participantServiceClient = new ParticipantServiceClient(endPointReference.getAddress(), endPointReference.getReference_parameters().getPrivate_instance());
    }


    public void commit(Xid xid, boolean b) throws XAException {
        participantServiceClient.xa_commit("dkjdk");
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void end(Xid xid, int i) throws XAException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void forget(Xid xid) throws XAException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getTransactionTimeout() throws XAException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isSameRM(javax.transaction.xa.XAResource xaResource) throws XAException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int prepare(Xid xid) throws XAException {
        PCResponse pcResponse = participantServiceClient.xa_prepare("dkfdk");
        Logger logger = LoggerFactory.getLogger(XAResource.class);
        if (pcResponse == PCResponse.prepared)
            return XAResource.XA_OK;
        else if(pcResponse == PCResponse.readOnly)
            return XAResource.XA_RDONLY;
        else throw new XAException();//To change body of implemented methods use File | Settings | File Templates.
    }

    public Xid[] recover(int i) throws XAException {
        return new Xid[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void rollback(Xid xid) throws XAException {
        participantServiceClient.xa_rollback("fkdjk");
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean setTransactionTimeout(int i) throws XAException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void start(Xid xid, int i) throws XAException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
