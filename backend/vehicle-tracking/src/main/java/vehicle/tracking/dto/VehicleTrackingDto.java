package vehicle.tracking.dto;

public class VehicleTrackingDto {

	private String positionName;

	// latitude
	private double lat;

	// longitude
	private double lng;

	public VehicleTrackingDto() {

	}

	public VehicleTrackingDto(double lat, double lng, String positionName) {
		this.lat = lat;
		this.lng = lng;
		this.positionName = positionName;
	}

	public VehicleTrackingDto(VehicleTrackingDto dto) {
		lat = dto.getLat();
		lng = dto.getLng();
	}

	public String getPositionName() { return positionName; }

	public void setPositionName(String positionName) { this.positionName = positionName; }

	public double getLat() { return lat; }

	public void setLat(double lat) { this.lat = lat; }

	public double getLng() { return lng; }

	public void setLng(double lng) { this.lng = lng; }

	@Override
	public String toString() {
		return lat + ", " + lng;
	}
}
