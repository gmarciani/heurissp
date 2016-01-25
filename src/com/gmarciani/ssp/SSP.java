package com.gmarciani.ssp;

import com.gmarciani.ssp.control.App;

public final class SSP {

	public static void main(String[] args) {
		App app = App.getInstance();
		app.play(args);
	}
}
