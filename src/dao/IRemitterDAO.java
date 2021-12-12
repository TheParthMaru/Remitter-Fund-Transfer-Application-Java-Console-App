package dao;

import java.util.List;

import model.Remitter;
import model.RemitterPersonal;

public interface IRemitterDAO {

	/*
	 * Add a new remitter
	 */
	public int addRemitter(Remitter remitter);

	/*
	 * Verify whether the remitter credentials exists in db or not.
	 */
	public int verifyRemitter(Remitter remitter);

	public int updateRemitterEmail(RemitterPersonal remitterPersonal);

	public int updateRemitterPassword(Remitter remitter);

	public int updateRemitterMobile(RemitterPersonal remitterPersonal);

	public int updateRemitterAddress(RemitterPersonal remitterPersonal);

	public int addRemitterDetails(RemitterPersonal remitterPersonal);

	public List<RemitterPersonal> viewPersonalDetails(RemitterPersonal remitterPersonal);

	public int showRemitterId(Remitter remitter);

}
