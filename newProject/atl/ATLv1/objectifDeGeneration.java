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



    // Set starting and ending nodes of the graph
    graph.setStartingNode(stopped);
    graph.addEndingNode(shutDown);

    // All posible switch from the node <stopped>
    graph.addSwitch(stopped, accelerate, "Accelerer");
    graph.addSwitch(stopped, shutDown, "Eteindre");

    // All posible switch from the node <accelerate>
    graph.addSwitch(accelerate, moveFoward, "Avancer");
    graph.addSwitch(accelerate, moveBackward, "Reculer");
    graph.addSwitch(accelerate, shutDown, "Eteindre");

    // All posible switch from the node <moveFoward>
    graph.addSwitch(moveFoward, slowDown, "Ralentir");
    graph.addSwitch(moveFoward, shutDown, "Eteindre");

    // All posible switch from the node <moveBackward>
    graph.addSwitch(moveBackward, slowDown, "Ralentir");
    graph.addSwitch(moveBackward, shutDown, "Eteindre");

    // All posible switch from the node <SlowDown>
    graph.addSwitch(slowDown, stopped, "Arreter");
    graph.addSwitch(slowDown, shutDown, "Eteindre");

    // AFter graph initialization, run the graph execution
    graph.run();

  }

}
