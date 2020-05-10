// Event creation

// Event corresponding to "Forward"
public class ForwardEvent extends Event {
  public void ForwardEvent() {
    super("Forward");
  }
}

// Event corresponding to "Backward"
public class BackwardEvent extends Event {
  public void BackwardEvent() {
    super("Backward");
  }
}

// Event corresponding to "Accelerate"
public class AccelerateEvent extends Event {
  public void AccelerateEvent() {
    super("Accelerate");
  }
}

// Event corresponding to "Solwdown"
public class SolwdownEvent extends Event {
  public void SolwdownEvent() {
    super("Solwdown");
  }
}

// Event corresponding to "TurnLeft"
public class TurnLeftEvent extends Event {
  public void TurnLeftEvent() {
    super("TurnLeft");
  }
}

// Event corresponding to "TurnRight"
public class TurnRightEvent extends Event {
  public void TurnRightEvent() {
    super("TurnRight");
  }
}

// Event corresponding to "Shutdown"
public class ShutdownEvent extends Event {
  public void ShutdownEvent() {
    super("Shutdown");
  }
}


// Action creation

// Acction corresponding to "setSpeed(...)"
public class SetSpeed extends Action {
  private int value;

  public void SetSpeed(int value) {
    this.value = value;
  }

  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}

// Acction corresponding to "increaseSpeed()"
public class IncreaseSpeed extends Action {
  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}

// Acction corresponding to "decreaseSpeed()"
public class DecreaseSpeed extends Action {
  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}

// Acction corresponding to "rotateleft()"
public class Rotateleft extends Action {
  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}

// Acction corresponding to "rotateright()"
public class Rotateright extends Action {
  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}

// Acction corresponding to "shutdown()"
public class Shutdown extends Action {
  public void execute(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}


// Guard creation

// Guard corresponding to "SpeedEquals(...)"
public class SpeedEquals extends Guard {
  private int value;

  public void SpeedEquals(int value) {
   this.value = value;
  }

  public boolean check(Metadata data, Parameter parameter) {
    //TODO: complete this function
  }
}


// Metadata creation
public class MyMetadata extends Metadata {
  //TODO: add variables used in functions
}


// Main Application
public class Application{

  public static void main(String[] args){

    // Statechart initialisation
    Statechart statechart = new Statechart();

    // Main states creation
    PseudoState startState = new PseudoState("Start", statechart, PseudoState.pseudostate_start);
    FinalState stopState = new FinalState("Stop", statechart);
    State initialState = new State("Initial", statechart);

    // Initial states creation
    State stoppedState = new State("Stopped", initialState);
    State moveFowardState = new State("MoveFoward", initialState);
    State moveBackwardState = new State("MoveBackward", initialState);
    PseudoState forwardJoinState = new PseudoState("ForwardJoin", initialState, PseudoState.pseudostate_junction);
    PseudoState backwardJoinState = new PseudoState("BackwardJoin", initialState, PseudoState.pseudostate_junction);

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
