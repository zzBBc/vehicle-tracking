package ctdl.simplewebwithpriorityqueue.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ctdl.simplewebwithpriorityqueue.Constants;
import ctdl.simplewebwithpriorityqueue.dto.EdgeDto;
import ctdl.simplewebwithpriorityqueue.dto.VehicleTrackingDto;
import ctdl.simplewebwithpriorityqueue.service.Check;
import ctdl.simplewebwithpriorityqueue.service.Sort;

//@CrossOrigin(origins = {
//		"http://localhost:3000", "http://localhost:4200", "http://localhost:8125", "http://192.168.1.179:8081"
//})
@RestController
@RequestMapping("/api/vehicle/")
public class RestVehicleController {
	@Autowired
	Sort sort;

	@Autowired
	Check check;

	@GetMapping("/getDirection")
	public ResponseEntity<List<EdgeDto>> getDirection() {
		List<EdgeDto> direction = new ArrayList<>();
		Constants constants = new Constants();

		// Create list vertices
		List<VehicleTrackingDto> vertices = constants.getVertices();
		// Create edges from vertices
		List<EdgeDto> edges = constants.setEdgesFromVertices(vertices);

		// Sort edges by capacity ascending
		Collections.sort(edges, new SortbyC());

		// Add edges to list direction
		for(EdgeDto edge: edges){
			if(direction.size() == 0){
				direction.add(edge);

				continue;
			}

			if(!check.checkDuplicateStart(edge.getStart(), direction)
					&& !check.checkCycle(edge, direction, vertices.size())){
				direction.add(edge);
				// Sort direction by cycle
				direction = sort.sortDirection(direction);

				continue;
			}

			if(direction.size() == vertices.size())
				break;
		}

		for(EdgeDto edge: direction)
			System.out.println(edge);

		return new ResponseEntity<>(direction, direction != null? HttpStatus.OK : HttpStatus.NO_CONTENT);
	}

	class SortbyC implements Comparator<EdgeDto> {
		@Override
		public int compare(EdgeDto a, EdgeDto b) {
			if(a.getCapacity() - b.getCapacity() < 0)
				return -1;
			if(a.getCapacity() - b.getCapacity() == 0)
				return 0;
			else
				return 1;
		}
	}
}
