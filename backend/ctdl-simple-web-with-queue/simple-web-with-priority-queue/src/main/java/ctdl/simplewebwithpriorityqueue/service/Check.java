package ctdl.simplewebwithpriorityqueue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ctdl.simplewebwithpriorityqueue.dto.EdgeDto;
import ctdl.simplewebwithpriorityqueue.dto.VehicleTrackingDto;

@Service
public class Check {
	public boolean checkDuplicateStart(VehicleTrackingDto verticesStart, List<EdgeDto> direction) {
		for(EdgeDto tempEdge: direction)
			if(tempEdge.getStart().equals(verticesStart))
				return true;
		return false;
	}

	public boolean checkCycle(EdgeDto edge, List<EdgeDto> direction, int verticesSize) {
		VehicleTrackingDto verticesStart = edge.getStart();
		VehicleTrackingDto verticesFinish = edge.getFinish();

		boolean scanEdge = false;
		while(scanEdge == false)
			for(int i = 0; i < direction.size(); i++){
				// When cycle = 4 has been accepted
				if(checkFinalEdge(direction, edge, verticesSize))
					return false;

				if(verticesFinish.equals(verticesStart))
					return true;

				if(verticesFinish.equals(direction.get(i).getStart())){
					verticesFinish = direction.get(i).getFinish();
					break;
				}

				if(i == direction.size() - 1)
					scanEdge = true;
			}

		return false;
	}

	private boolean checkFinalEdge(List<EdgeDto> direction, EdgeDto edge, int verticesSize) {
		if(direction.size() != verticesSize - 1)
			return false;

		for(EdgeDto tempEdge: direction)
			if(edge.getStart().equals(tempEdge.getStart()) || edge.getFinish().equals(tempEdge.getFinish()))
				return false;

		return true;
	}
}
