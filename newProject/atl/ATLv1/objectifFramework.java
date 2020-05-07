// Event corresponding to "Allumer"
class AllumerEvent extends Event {
  public AllumerEvent() {
    super("Allumer");
  }
}

// Event corresponding to "Eteindre"
class EteindreEvent extends Event {
  public EteindreEvent() {
    super("Eteindre");
  }
}

// Event corresponding to "Avancer"
class AvancerEvent extends Event {
  public AvancerEvent() {
    super("Avancer");
  }
}

// Event corresponding to "Reculer"
class ReculerEvent extends Event {
  public ReculerEvent() {
    super("Reculer");
  }
}

// Event corresponding to "Accelerer"
class AccelererEvent extends Event {
  public AccelererEvent() {
    super("Accelerer");
  }
}

// Event corresponding to "Ralentir"
class RalentirEvent extends Event {
  public RalentirEvent() {
    super("Ralentir");
  }
}

// Event corresponding to "Arreter"
class ArreterEvent extends Event {
  public ArreterEvent() {
    super("Arreter");
  }
}

public class Application{

  public static void main(String[] args){

    // Statechart initialisation
    Statechart statechart = new Statechart();

    // Start and final states creation
    PseudoState startState = new PseudoState("Start", statechart, PseudoState.pseudostate_start);
    FinalState finalState = new FinalState("Final", statechart);

    // States creation
    State stoppedState = new State("Stopped", statechart);
    State accelerateState = new State("Accelerate", statechart);
    State moveFowardState = new State("MoveFoward", statechart);
    State moveBackwardState = new State("MoveBackward", statechart);
    State slowDownState = new State("SlowDown", statechart);
    State shutDownState = new State("Shutdown", statechart);

    // Transitions from state "Start"
    new Transition(startState, stoppedState, AllumerEvent);

    // Transitions from state "Stopped"
    new Transition(stoppedState, accelerateState, AccelererEvent);
    new Transition(stoppedState, shutDownState, EteindreEvent);

    // Transitions from state "Accelerate"
    new Transition(accelerateState, moveFowardState, AvancerEvent);
    new Transition(accelerateState, moveBackwardState, ReculerEvent);
    new Transition(accelerateState, shutDownState, EteindreEvent);

    // Transitions from state "MoveFoward"
    new Transition(moveFowardState, slowDownState, RalentirEvent);
    new Transition(moveFowardState, shutDownState, EteindreEvent);

    // Transitions from state "MoveBackward"
    new Transition(moveBackwardState, slowDownState, RalentirEvent);
    new Transition(moveBackwardState, shutDownState, EteindreEvent);

    // Transitions from state "SlowDown"
    new Transition(slowDownState, stoppedState, ArreterEvent);
    new Transition(slowDownState, shutDownState, EteindreEvent);

    // Transitions from state "Shutdown"
    new Transition(shutDownState, finalState);

  }

}
