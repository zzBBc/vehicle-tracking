package vehicle.tracking.dto;

public class EdgeDto {
	private VehicleTrackingDto start;
	private VehicleTrackingDto finish;

	private double capacity;

	public EdgeDto(VehicleTrackingDto start, VehicleTrackingDto finish, double capacity) {
		this.start = start;
		this.finish = finish;
		this.capacity = capacity;
	}

	public VehicleTrackingDto getStart() { return start; }

	public void setStart(VehicleTrackingDto start) { this.start = start; }

	public VehicleTrackingDto getFinish() { return finish; }

	public void setFinish(VehicleTrackingDto finish) { this.finish = finish; }

	public double getCapacity() { return capacity; }

	public void setCapacity(double capacity) { this.capacity = capacity; }

	@Override
	public String toString() {
		return "Start: " + start + ", finish: " + finish + ", c: " + capacity;
	}

}
