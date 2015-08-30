package shifan.service;

import java.util.List;

import shifan.pojo.Hygiene;

public interface HygieneService {
	public List<Hygiene> findAllHygiene()throws Exception;

	public boolean save(Hygiene hygiene)throws Exception;

}
