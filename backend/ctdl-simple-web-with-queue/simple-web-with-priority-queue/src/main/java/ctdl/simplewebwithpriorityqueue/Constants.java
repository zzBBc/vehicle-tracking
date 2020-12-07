package ctdl.simplewebwithpriorityqueue;

import java.util.ArrayList;
import java.util.List;

import ctdl.simplewebwithpriorityqueue.dto.EdgeDto;
import ctdl.simplewebwithpriorityqueue.dto.VehicleTrackingDto;

public final class Constants {
	// HUS
	VehicleTrackingDto tracking0 = new VehicleTrackingDto(20.9953795115114, 105.80831766128541, "HUS");

	// 149 Nguyen Tuan: 20.998649876448347, 105.80297201871873
	VehicleTrackingDto tracking1 = new VehicleTrackingDto(20.998649876448347, 105.80297201871873, "149 Nguyễn Tuân");

	// Cho Nhan Chinh: 20.99835439465859, 105.80927789211273
	VehicleTrackingDto tracking2 = new VehicleTrackingDto(20.99835439465859, 105.80927789211273, "Chợ Nhân Chính");

	// Royal City: 21.001128895542955, 105.81684172153474
	VehicleTrackingDto tracking3 = new VehicleTrackingDto(21.001128895542955, 105.81684172153474, "Royal City");

	private List<VehicleTrackingDto> vertices = new ArrayList<>();

	private List<EdgeDto> edges = new ArrayList<>();

	public Constants() {
		setVertices();
	}

	public void setVertices() {
		// Add vertices
		vertices.add(tracking0);
		vertices.add(tracking1);
		vertices.add(tracking2);
		vertices.add(tracking3);
	}

	public List<EdgeDto> setEdgesFromVertices(List<VehicleTrackingDto> vertices) {
		List<EdgeDto> edges = new ArrayList<>();
		// Add edges
		for(VehicleTrackingDto edgeStart: vertices)
			for(VehicleTrackingDto edgeFinal: vertices){
				if(edgeStart == edgeFinal)
					continue;

				double c = capacityCalculation(edgeStart, edgeFinal);

				edges.add(new EdgeDto(edgeStart, edgeFinal, c));
			}
		return edges;
	}

	public double capacityCalculation(VehicleTrackingDto edgeStart, VehicleTrackingDto edgeFinal) {
		return Math.sqrt(Math.pow(edgeStart.getLat() - edgeFinal.getLat(), 2)
				+ Math.pow(edgeStart.getLng() - edgeFinal.getLng(), 2));
	}

	public List<VehicleTrackingDto> getVertices() { return vertices; }

	public void setVertices(List<VehicleTrackingDto> vertices) { this.vertices = vertices; }

	public List<EdgeDto> getEdges() { return edges; }

	public void setEdges(List<EdgeDto> edges) { this.edges = edges; }

}
