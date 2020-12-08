package vehicle.tracking.dto;

public class VertexTrackingDto {

	private String positionName;

	// latitude (vĩ độ)
	private double lat;

	// longitude (kinh độ)
	private double lng;

	public VertexTrackingDto() {

	}

	public VertexTrackingDto(double lat, double lng, String positionName) {
		this.lat = lat;
		this.lng = lng;
		this.positionName = positionName;
	}

	public VertexTrackingDto(VertexTrackingDto dto) {
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
