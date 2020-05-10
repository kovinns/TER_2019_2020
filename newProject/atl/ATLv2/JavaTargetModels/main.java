/* 
 * Automatically generated Java code with ATL 
 */ 
 
// Event corresponding to "Shutdown"
	 public class ShutdownEvent extends Event {
			public ShutdownEvent() {
	 			super("Shutdown");
	 	}
	}

// Event corresponding to "Backward"
	 public class BackwardEvent extends Event {
			public BackwardEvent() {
	 			super("Backward");
	 	}
	}

// Event corresponding to "Forward"
	 public class ForwardEvent extends Event {
			public ForwardEvent() {
	 			super("Forward");
	 	}
	}

// Event corresponding to "TurnLeftForward"
	 public class TurnLeftForwardEvent extends Event {
			public TurnLeftForwardEvent() {
	 			super("TurnLeftForward");
	 	}
	}

// Event corresponding to "TurnRightForward"
	 public class TurnRightForwardEvent extends Event {
			public TurnRightForwardEvent() {
	 			super("TurnRightForward");
	 	}
	}

// Event corresponding to "TurnLeftBackward"
	 public class TurnLeftBackwardEvent extends Event {
			public TurnLeftBackwardEvent() {
	 			super("TurnLeftBackward");
	 	}
	}

// Event corresponding to "TurnRightBackward"
	 public class TurnRightBackwardEvent extends Event {
			public TurnRightBackwardEvent() {
	 			super("TurnRightBackward");
	 	}
	}

// Event corresponding to "SlowdownBackward"
	 public class SlowdownBackwardEvent extends Event {
			public SlowdownBackwardEvent() {
	 			super("SlowdownBackward");
	 	}
	}

// Event corresponding to "SlowdownForward"
	 public class SlowdownForwardEvent extends Event {
			public SlowdownForwardEvent() {
	 			super("SlowdownForward");
	 	}
	}

// Event corresponding to "Accelerate"
	 public class AccelerateEvent extends Event {
			public AccelerateEvent() {
	 			super("Accelerate");
	 	}
	}

// Event corresponding to "AccelerateBackward"
	 public class AccelerateBackwardEvent extends Event {
			public AccelerateBackwardEvent() {
	 			super("AccelerateBackward");
	 	}
	}

// Action creation

// Action corresponding to "setSpeed(...)"
public class SetSpeed extends Action {
  private int value;

  public void SetSpeed(int value) {
    this.value = value;
  }

  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}

// Action corresponding to "increaseSpeed()"
public class IncreaseSpeed extends Action {
  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}

// Action corresponding to "decreaseSpeed()"
public class DecreaseSpeed extends Action {
  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}

// Action corresponding to "rotateleft()"
public class Rotateleft extends Action {
  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}

// Action corresponding to "rotateright()"
public class Rotateright extends Action {
  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}

// Action corresponding to "shutdown()"
public class Shutdown extends Action {
  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}
		// Guard creation

// Guard corresponding to "SpeedEquals(...)"
public class SpeedEquals extends Guard {
  private int value;

  public SpeedEquals(int value) {
   this.value = value;
  }

  public boolean check(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}// Metadata creation
public class MyMetadata extends Metadata {
  //TODO: add variables used in functions
}

// Main Application
public class Application{

  public static void main(String[] args){

    // Statechart initialisation
    Statechart statechart = new Statechart();// Main states creation
	PseudoState startState = new PseudoState("Start", statechart, PseudoState.pseudostate_start);
	FinalState stopState = new FinalState("Stop", statechart);
	State initialState = new State("Initial", statechart);

    // Initial states creation		
    State movebackwardState = new State("MoveBackward", initialState);
    State moveforwardState = new State("MoveForward", initialState);
    State stoppedState = new State("Stopped", initialState);
    PseudoState backwardjoinPseudoState = new State("BackwardJoin", initialState);
    PseudoState forwardjoinPseudoState = new State("ForwardJoin", initialState);

    // Transitions from state "Start"
    new Transition(startState, stoppedState);

    // Transitions from state "Initial"
    new Transition(initialState, stoppedState, new ShutdownEvent(), new Shutdown());

    // Transitions from state "Stopped"
    new Transition(stoppedState, moveFowardState, new ForwardEvent(), new SetSpeed(1));
    new Transition(stoppedState, moveBackwardState, new BackwardEvent(), new SetSpeed(-1));

    // Transitions from state "MoveFoward"
    new Transition(moveFowardState, moveFowardState, new TurnLeftEvent(), new Rotateleft());
    new Transition(moveFowardState, moveFowardState, new TurnRightEvent(), new Rotateright());
    new Transition(moveFowardState, moveFowardState, new Accelerate(), new IncreaseSpeed());
    new Transition(moveFowardState, forwardJoinState, new SolwdownEvent(), new DecreaseSpeed());

    // Transitions from state "MoveBackward"
    new Transition(moveBackwardState, moveBackwardState, new TurnLeftEvent(), new Rotateleft());
    new Transition(moveBackwardState, moveBackwardState, new TurnRightEvent(), new Rotateright());
    new Transition(moveBackwardState, moveBackwardState, new Accelerate(), new DecreaseSpeed());
    new Transition(moveBackwardState, backwardJoinState, new SolwdownEvent(), new IncreaseSpeed());

    // Transitions from state "forwardJoinState"
    new Transition(forwardJoinState, stoppedState, new SpeedEquals(0));
    new Transition(forwardJoinState, moveFowardState);

    // Transitions from state "backwardJoinState"
    new Transition(backwardJoinState, stoppedState, new SpeedEquals(0));
    new Transition(backwardJoinState, moveBackwardState);

	//Run the statechart
    MyMetadata myMetadata = new MyMetadata();
    chart.start(myMetadata);
	}
}