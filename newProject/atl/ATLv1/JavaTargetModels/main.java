/* 
 * Automatically generated Java code with ATL 
 */ 
 // Specific class and methods description for the node <Stopped>
	public class Stopped extends Node {
	
	  @Override
	  public void onEventStart(){
	    //TODO : Complete with the code to execute when an event is called on this node
	  }

	  @Override
	  public void onEventDestination(){
	    //TODO : Complete with the code to execute when an event leads to this node
	  }
	
	  @Override
	  public void onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  public void onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

// Specific class and methods description for the node <Accelerate>
	public class Accelerate extends Node {
	
	  @Override
	  public void onEventStart(){
	    //TODO : Complete with the code to execute when an event is called on this node
	  }

	  @Override
	  public void onEventDestination(){
	    //TODO : Complete with the code to execute when an event leads to this node
	  }
	
	  @Override
	  public void onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  public void onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

// Specific class and methods description for the node <MoveForward>
	public class MoveForward extends Node {
	
	  @Override
	  public void onEventStart(){
	    //TODO : Complete with the code to execute when an event is called on this node
	  }

	  @Override
	  public void onEventDestination(){
	    //TODO : Complete with the code to execute when an event leads to this node
	  }
	
	  @Override
	  public void onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  public void onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

// Specific class and methods description for the node <MoveBackward>
	public class MoveBackward extends Node {
	
	  @Override
	  public void onEventStart(){
	    //TODO : Complete with the code to execute when an event is called on this node
	  }

	  @Override
	  public void onEventDestination(){
	    //TODO : Complete with the code to execute when an event leads to this node
	  }
	
	  @Override
	  public void onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  public void onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

// Specific class and methods description for the node <SlowDown>
	public class SlowDown extends Node {
	
	  @Override
	  public void onEventStart(){
	    //TODO : Complete with the code to execute when an event is called on this node
	  }

	  @Override
	  public void onEventDestination(){
	    //TODO : Complete with the code to execute when an event leads to this node
	  }
	
	  @Override
	  public void onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  public void onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

// Specific class and methods description for the node <ShutDown>
	public class ShutDown extends Node {
	
	  @Override
	  public void onEventStart(){
	    //TODO : Complete with the code to execute when an event is called on this node
	  }

	  @Override
	  public void onEventDestination(){
	    //TODO : Complete with the code to execute when an event leads to this node
	  }
	
	  @Override
	  public void onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  public void onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

public class Application{

  public static void main(String[] args){
    // Graph initialization
    Graph graph = new Graph();

    // Nodes initionazation and adding to the graph
Stopped stopped = new Stopped();
graph.addNode(stopped);

Accelerate accelerate = new Accelerate();
graph.addNode(accelerate);

MoveForward moveforward = new MoveForward();
graph.addNode(moveforward);

MoveBackward movebackward = new MoveBackward();
graph.addNode(movebackward);

SlowDown slowdown = new SlowDown();
graph.addNode(slowdown);

ShutDown shutdown = new ShutDown();
graph.addNode(shutdown);

// Set starting nodes of the graph
graph.setStartingNode(Stopped);

// Set ending nodes of the graph
graph.setEndingNode(ShutDown);

//Set the transitions
graph.addSwitch(Stopped, Accelerate, "Accelerer");
graph.addSwitch(Accelerate, MoveForward, "Avancer");
graph.addSwitch(Accelerate, MoveBackward, "Reculer");
graph.addSwitch(MoveForward, SlowDown, "Ralentir");
graph.addSwitch(MoveBackward, SlowDown, "Ralentir");
graph.addSwitch(SlowDown, ShutDown, "Eteindre");
graph.addSwitch(Stopped, ShutDown, "Eteindre");
graph.addSwitch(Accelerate, ShutDown, "Eteindre");
graph.addSwitch(MoveBackward, ShutDown, "Eteindre");
graph.addSwitch(SlowDown, Stopped, "Arreter");
graph.addSwitch(MoveForward, ShutDown, "Eteindre");

    // After graph initialization, run the graph execution
    graph.run();
	}
}