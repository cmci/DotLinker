package emblcmci.obj;


import java.util.Collection;

import emblcmci.linker.LinkAnalyzer;

public class Tracks2Dcells extends AbstractTracks{	
	
	public AbstractTracks addTrack(int ID, Track2Dcells t){
		put(ID, t);
		t.setTrackID(ID);
		return this;
	}
	/** 
	 * visitor acceptance (now for analyzer as a visitor)
	 * ... this will be the entry point for analysis of Tracks. 
	 */
	@Override
	public void accept(LinkAnalyzer analyzer) {
		analyzer.analyze(this);
	}


	
}
