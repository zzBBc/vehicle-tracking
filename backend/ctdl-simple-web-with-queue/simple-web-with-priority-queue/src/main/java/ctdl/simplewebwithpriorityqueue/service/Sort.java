package ctdl.simplewebwithpriorityqueue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ctdl.simplewebwithpriorityqueue.dto.EdgeDto;

@Service
public class Sort {
	public List<EdgeDto> sortDirection(List<EdgeDto> direction) {
		List<EdgeDto> newDirection = new ArrayList<>();
		EdgeDto startEdge = direction.get(0);
		newDirection.add(startEdge);

		boolean scanEdge = false;
		while(scanEdge == false){
			if(newDirection.size() == direction.size())
				break;

			int prevSize = newDirection.size();

			for(int i = 0; i < direction.size(); i++){
				if(newDirection.size() == direction.size()){
					scanEdge = true;
					break;
				}

				if(startEdge.getFinish().getLat() - direction.get(i).getStart().getLat() == 0){
					newDirection.add(direction.get(i));
					startEdge = direction.get(i);
					break;
				}
			}

			if(newDirection.size() == prevSize)
				for(EdgeDto edge: direction)
					if(!existInNewDirection(edge, newDirection))
						newDirection.add(edge);
		}

		return newDirection;
	}

	private boolean existInNewDirection(EdgeDto edge, List<EdgeDto> newDirection) {
		for(EdgeDto tempEdge: newDirection)
			if(edge.equals(tempEdge))
				return true;
		return false;
	}
}
