package c.culte.api;

public interface Views {
	public static interface Common {}	
	
	public static interface Demande extends Common {}
	
	public static interface Evenement extends Common {}
	
	public static interface Don extends Common {}
	
	public static interface Tapoteur extends Common {}
	public static interface Indenteur extends Tapoteur {}
	public static interface Compileur extends Tapoteur {}
	public static interface Fidele extends Tapoteur {}
	public static interface GrandDev extends Tapoteur {}
	
	public static interface Bannis extends Common {}
}
