package vehicle.tracking.dto;

// Cạnh
public class EdgeDto {
	private VertexTrackingDto start;
	private VertexTrackingDto finish;

	// Trọng số
	private double capacity;

	public EdgeDto(VertexTrackingDto start, VertexTrackingDto finish, double capacity) {
		this.start = start;
		this.finish = finish;
		this.capacity = capacity;
	}

	public VertexTrackingDto getStart() { return start; }

	public void setStart(VertexTrackingDto start) { this.start = start; }

	public VertexTrackingDto getFinish() { return finish; }

	public void setFinish(VertexTrackingDto finish) { this.finish = finish; }

	public double getCapacity() { return capacity; }

	public void setCapacity(double capacity) { this.capacity = capacity; }

	@Override
	public String toString() {
		return "Start: " + start + ", finish: " + finish + ", c: " + capacity;
	}

}
