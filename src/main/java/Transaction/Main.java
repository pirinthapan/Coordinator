package Transaction;

import acidoth.thrift.xa.EndPointReference;
import acidoth.thrift.xa.ReferenceParameters;
import com.atomikos.icatch.jta.UserTransactionManager;
import XAResources.XAResource;

import javax.transaction.*;

/**
 * Created with IntelliJ IDEA.
 * User: pirinthapan
 * Date: 6/13/13
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public Main(XAResource xaResource){

    }

    public static void main(String[] args) throws NotSupportedException, SystemException, RollbackException, HeuristicRollbackException, HeuristicMixedException {

        UserTransactionManager utm = new UserTransactionManager();
        utm.begin();

        EndPointReference epr = new EndPointReference();
        ReferenceParameters rp = new ReferenceParameters();

        EndPointReference epr1 = new EndPointReference();
        ReferenceParameters rp1 = new ReferenceParameters();

        epr.setAddress("localhost");
        rp.setPrivate_instance(9090);
        epr.setReference_parameters(rp);

        epr1.setAddress("localhost");
        rp1.setPrivate_instance(9091);
        epr1.setReference_parameters(rp1);

        Transaction transaction = utm.getTransaction();
        XAResource resources = new XAResource(epr);
        XAResource resource1 = new XAResource(epr1);

        transaction.enlistResource(resources);
        transaction.enlistResource(resource1);

        utm.commit();

    }
}
