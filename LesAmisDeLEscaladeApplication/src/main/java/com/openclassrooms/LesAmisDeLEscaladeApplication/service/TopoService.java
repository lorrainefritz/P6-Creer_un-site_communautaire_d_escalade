package com.openclassrooms.LesAmisDeLEscaladeApplication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Topo;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.User;
import com.openclassrooms.LesAmisDeLEscaladeApplication.repository.TopoRepository;

@Service
public class TopoService {
	private final Logger logger = LoggerFactory.getLogger(TopoService.class);

	@Autowired
	TopoRepository topoRepository;

//	@Autowired
//	private UserServiceImplementation userServiceImplementation;
//	
	public List<Topo> getAllTopos() {
		List<Topo> listOfTopos = topoRepository.findAll();
		return listOfTopos;
	}

	public Topo addTopo(Topo topo) {
		logger.info("in TopoService addTopo");
//		List<Topo> userTopoColl = (List<Topo>)user.getTopos();
//		userTopoColl.add(topo);
		return topoRepository.save(topo);
	}

	public void deleteTopo(Integer id) {
		logger.info("in TopoService deleteTopo, deleteTopo with id " +id);
//		List<Topo> userTopoColl = (List<Topo>)user.getTopos();
//		Topo topo =userTopoColl.get(id);
//		userTopoColl.remove(topo);
		topoRepository.deleteById(id);
	}

	public Topo getOneTopoById(Integer id) {
		logger.info("in TopoService getOneTopoById");
		return topoRepository.getOne(id);
	}

	public void saveTopo(Topo topo) {
		logger.info("in TopoService saveTopo");
		topoRepository.save(topo);
	}

}
