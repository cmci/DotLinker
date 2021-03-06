package de.embl.cmci.obj.converters;

import ij.measure.ResultsTable;

import java.util.ArrayList;

import de.embl.cmci.obj.AbstractTrack;
import de.embl.cmci.obj.AbstractTracks;
import de.embl.cmci.obj.Node;
import de.embl.cmci.obj.Track;
import de.embl.cmci.obj.Tracks;


/**
 * Converts data in Results Table to Tracks instance holding multiple Track instances.
 * Each Track is a class with Node objects stroed as an AraryList.
 * 
 * Implementation: simple version, only requires xy coordinates, frame number and TrackID.
 * 
 * @param trt: ImageJ results table instance. 
 * @return
 */

public class ResultTableToTracks extends AbstractResultsTableToTracks{

	public ResultTableToTracks(ResultsTable trt) {
		super(trt);
	}

	@Override
	Node generateNode(Integer i) {
		Node node = new Node(
				trt.getValue("Xpos", i), 
				trt.getValue("Ypos", i),
				(int) trt.getValue("frame", i), 
				(int) trt.getValue("TrackID", i),
				i);
		return node;
	}

	@Override
	AbstractTracks createTracks() {
		return new Tracks();
	}

	@Override
	AbstractTrack createTrack() {
		return new Track(new ArrayList<Node>());
	}

	@Override
	boolean checkHeaders() {
		if (	trt.getColumnHeadings().contains("Xpos") &&
				trt.getColumnHeadings().contains("Ypos") &&
				trt.getColumnHeadings().contains("frame") &&
				trt.getColumnHeadings().contains("TrackID")
			)
			return true;
		else 
			return false;
	}

	@Override
	boolean checkHeaderLength(int rowlength) {
		if (rowlength > 3)
			return true;
		else
			return false;
	}

	@Override
	void calcTrackParameters() {
		// Do nothing in case of this simple implementation. 
	}
}
