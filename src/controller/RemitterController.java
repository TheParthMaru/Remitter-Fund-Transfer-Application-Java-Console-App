package controller;

import java.util.List;

import dao.RemitterDAOImpl;
import model.Remitter;
import model.RemitterPersonal;

public class RemitterController {
	Remitter remitter;
	RemitterPersonal remitterPersonal;

	RemitterDAOImpl impl = new RemitterDAOImpl();

	public int addRemitter(String name, String password, Long accountNumber, Long accountBalance, String accountType) {
		remitter = new Remitter(name, password, accountNumber, accountBalance, accountType);

		return impl.addRemitter(remitter);
	}

	public int verifyRemitter(Long id, String password) {
		remitter = new Remitter(id, password);
		return impl.verifyRemitter(remitter);
	}

	public int updateRemitterEmail(Long rid, String email) {
		remitterPersonal = new RemitterPersonal();
		remitterPersonal.setEmail(email);
		remitterPersonal.setRid(rid);
		return impl.updateRemitterEmail(remitterPersonal);
	}

	public int updateRemitterPassword(Long rid, String password) {
		remitter = new Remitter();
		remitter.setId(rid);
		remitter.setPassword(password);
		return impl.updateRemitterPassword(remitter);
	}

	public int updateRemitterMobile(Long rid, Long mobile) {
		remitterPersonal = new RemitterPersonal();
		remitterPersonal.setRid(rid);
		remitterPersonal.setMobile(mobile);
		return impl.updateRemitterMobile(remitterPersonal);
	}

	public int updateRemitterAddress(Long rid, String address) {
		remitterPersonal = new RemitterPersonal();
		remitterPersonal.setRid(rid);
		remitterPersonal.setAddress(address);
		return impl.updateRemitterAddress(remitterPersonal);
	}

	public int addRemitterDetails(Long rid, String email, Long mobile, String address) {
		remitterPersonal = new RemitterPersonal(rid, email, mobile, address);
		remitterPersonal.setRid(rid);
		return impl.addRemitterDetails(remitterPersonal);
	}

	public List<RemitterPersonal> viewRemitterDetails(Long rid) {
		remitterPersonal = new RemitterPersonal();
		remitterPersonal.setRid(rid);
		return impl.viewPersonalDetails(remitterPersonal);
	}

	public int showRemitterId(Long accountNumber) {
		remitter = new Remitter();
		remitter.setAccountNumber(accountNumber);
		return impl.showRemitterId(remitter);
	}
}
