package cineroom.mvc.session;

public class Session {
	private String sessionId;
	
	public Session() {}
	public Session(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	@Override
	public String toString() {
		return "["+sessionId+"님 로그인 중입니다.]";
	}
	
	@Override
	public int hashCode() {
		return sessionId.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Session other = (Session) obj;
		if(sessionId.equals(other.sessionId)) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
