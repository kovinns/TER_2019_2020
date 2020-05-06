/* 
 * Automatically generated Java code with ATL 
 */ 
 // Specific class and methods description for the node <Stopped>
	class Stopped extends Node {
	
	  @Override
	  onEventStart(){
	    //TODO : Complete with the code to execute when an event is call on this node
	  }

	  @Override
	  onEventDestination(){
	    //TODO : Complete with the code to execute when an event lead to this node
	  }
	
	  @Override
	  onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

// Specific class and methods description for the node <Accelerate>
	class Accelerate extends Node {
	
	  @Override
	  onEventStart(){
	    //TODO : Complete with the code to execute when an event is call on this node
	  }

	  @Override
	  onEventDestination(){
	    //TODO : Complete with the code to execute when an event lead to this node
	  }
	
	  @Override
	  onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

// Specific class and methods description for the node <MoveForward>
	class MoveForward extends Node {
	
	  @Override
	  onEventStart(){
	    //TODO : Complete with the code to execute when an event is call on this node
	  }

	  @Override
	  onEventDestination(){
	    //TODO : Complete with the code to execute when an event lead to this node
	  }
	
	  @Override
	  onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

// Specific class and methods description for the node <MoveBackward>
	class MoveBackward extends Node {
	
	  @Override
	  onEventStart(){
	    //TODO : Complete with the code to execute when an event is call on this node
	  }

	  @Override
	  onEventDestination(){
	    //TODO : Complete with the code to execute when an event lead to this node
	  }
	
	  @Override
	  onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

// Specific class and methods description for the node <SlowDown>
	class SlowDown extends Node {
	
	  @Override
	  onEventStart(){
	    //TODO : Complete with the code to execute when an event is call on this node
	  }

	  @Override
	  onEventDestination(){
	    //TODO : Complete with the code to execute when an event lead to this node
	  }
	
	  @Override
	  onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

// Specific class and methods description for the node <ShutDown>
	class ShutDown extends Node {
	
	  @Override
	  onEventStart(){
	    //TODO : Complete with the code to execute when an event is call on this node
	  }

	  @Override
	  onEventDestination(){
	    //TODO : Complete with the code to execute when an event lead to this node
	  }
	
	  @Override
	  onEntering(){
	    //TODO : Complete with the code to execute when you enter in this node
	  }
	
	  @Override
	  onLeaving(){
	    //TODO : Complete with the code to execute when you leave this node
	  }
	
	}

class Application{

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