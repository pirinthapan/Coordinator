package server;

import XAResources.XAResource;
import org.apache.thrift.TException;

import acidoth.thrift.xa.*;

public class CoordinatorServiceHandler implements AcidothCoordinatorXAServices.Iface {

	public EndPointReference ax_register(CoordinationContext coorContext,
			String protocolIdentifier, EndPointReference protocolServiceEPR)
			throws TException {

		return null;
	}

}
