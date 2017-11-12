package Assignment3_EngineMachine;

import java.awt.Color;

public enum Status {
	OFF(Color.GRAY) {
		@Override
		public Status nextState(boolean on) {
			if (on == true)
				return WARMUP;
			else
				return OFF;
		}
	},
	WARMUP(Color.PINK) {
		@Override
		public Status nextState(boolean on) {
			if (on == true)
				return RUNNING;
			else
				return OFF;
		}
	},
	RUNNING(Color.RED) {
		@Override
		public Status nextState(boolean on) {
			if (on == true)
				return RUNNING;
			else
				return OFF;
		}
	};
	private Color c;

	private Status(Color c) {
		this.c = c;
	}

	public Color getColor() {
		return c;
	}

	public abstract Status nextState(boolean on);
}
