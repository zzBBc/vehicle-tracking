package vehicle.tracking;

import java.util.ArrayList;
import java.util.List;

import vehicle.tracking.dto.EdgeDto;
import vehicle.tracking.dto.VertexTrackingDto;

public final class Constants {
	// HUS
	VertexTrackingDto tracking0 = new VertexTrackingDto(20.9953795115114, 105.80831766128541, "HUS");

	// 149 Nguyen Tuan: 20.998649876448347, 105.80297201871873
	VertexTrackingDto tracking1 = new VertexTrackingDto(20.998649876448347, 105.80297201871873, "149 Nguyễn Tuân");

	// Cho Nhan Chinh: 20.99835439465859, 105.80927789211273
	VertexTrackingDto tracking2 = new VertexTrackingDto(20.99835439465859, 105.80927789211273, "Chợ Nhân Chính");

	// Royal City: 21.001128895542955, 105.81684172153474
	VertexTrackingDto tracking3 = new VertexTrackingDto(21.001128895542955, 105.81684172153474, "Royal City");

	private List<VertexTrackingDto> vertices = new ArrayList<>();

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

	public List<EdgeDto> setEdgesFromVertices(List<VertexTrackingDto> vertices) {
		List<EdgeDto> edges = new ArrayList<>();
		// Add edges
		for(VertexTrackingDto vertexStart: vertices)
			for(VertexTrackingDto vertexFinal: vertices){
				if(vertexStart == vertexFinal)
					continue;

				double c = capacityCalculation(vertexStart, vertexFinal);

				edges.add(new EdgeDto(vertexStart, vertexFinal, c));
			}
		return edges;
	}

	public double capacityCalculation(VertexTrackingDto edgeStart, VertexTrackingDto edgeFinal) {
		return Math.sqrt(Math.pow(edgeStart.getLat() - edgeFinal.getLat(), 2)
				+ Math.pow(edgeStart.getLng() - edgeFinal.getLng(), 2));
	}

	public List<VertexTrackingDto> getVertices() { return vertices; }

	public void setVertices(List<VertexTrackingDto> vertices) { this.vertices = vertices; }

	public List<EdgeDto> getEdges() { return edges; }

	public void setEdges(List<EdgeDto> edges) { this.edges = edges; }

}
