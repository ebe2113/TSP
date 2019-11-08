// STUDENT CODE STARTS HERE

  public void generateRandomVertices(int n) {
    vertexNames = new HashMap<>(); // reset the vertex hashmap
    
    for (int i=0; i<n; i++){
        Vertex a = new Vertex(i, (int)(Math.random()*(101)), (int)(Math.random()*(101))); 
        addVertex(a);
        for (Vertex v : getVertices()){
               addUndirectedEdge(i, v.name, 0);
        }    
    }
    computeAllEuclideanDistances(); // compute distances
  
  }

  public List<Edge> nearestNeighborTsp() {
      ArrayList<Edge> path = new ArrayList<Edge>(); 
      ArrayList<Vertex> map = new ArrayList<Vertex>(getVertices()); 
      
      Vertex initialVertex = findRandom(map); 
      System.out.println("hi" + initialVertex.name);
      
      ****
        *****
  }
  
  private void findNeighbor(Vertex initialV, Vertex startV, ArrayList<Edge> path){
      Vertex next = findClosest(startV); 
      
      if (next == null){
          Edge e = new Edge(startV, initialV, computeEuclideanDistance(startV, initialV)); 
          path.add(e); 
      }
       else{ 
           Edge uv = new Edge(startV, next , computeEuclideanDistance(startV, next));
           path.add(uv); 
           findNeighbor(initialV, next, path); 
       }    
  }
    
  private Vertex findClosest(Vertex start){  
      
      ArrayList<Edge> edges = new ArrayList<Edge>(start.adjacentEdges); 
      Edge closest = null; 
      
      for(int i = 0; i<edges.size(); i++){ 
          if (closest==null && edges.get(i).target.known==false){
                    closest = edges.get(i); 
          }
          else if(closest==null)
              continue; 

          if(closest.distance>edges.get(i).distance && edges.get(i).target.known==false){
              closest = edges.get(i); 
          }
      }
      
      if (closest ==null)
          return null; 
      else {
          closest.target.known = true; 
          return closest.target; 
      }  
  }
  

  private Vertex findRandom(ArrayList<Vertex> currMap){
     ***** 
  }

  public List<Edge> bruteForceTsp() { 
    ArrayList<Vertex> map = new ArrayList<Vertex>(getVertices());
   
    ArrayList<ArrayList<Vertex>> total = new ArrayList<ArrayList<Vertex>>(); 
    permute(total, map, map.size()); 
      
    ArrayList<ArrayList<Edge>> edges = vertexToEdge(total);  
    
    ArrayList<Edge> champ = edges.get(0);
    double champPath = getWeight(champ); 
      for (int i=1; i<edges.get(0).size(); i++){ 
        if(champPath>getWeight(edges.get(i))){
            champ = edges.get(i); 
            champPath = getWeight(edges.get(i)); 
        }
    }
    return champ; 
  }
  
  private double getWeight(ArrayList<Edge> edges){
     *****
  }
    
  private void permute(ArrayList<ArrayList<Vertex>> total, ArrayList<Vertex> sub, int size){
      
      ArrayList<Vertex> arr = new ArrayList<Vertex>(sub.subList(0, sub.size()));  
      if(size ==1){
          total.add(arr);
      }
      
      for(int i=0; i<size; i++){
          permute(total, arr, size-1);
          Vertex x = arr.get(i); 
          Vertex y = arr.get(size-1); 
          arr.set(i, y); 
          arr.set(size-1, x); 
      }
  }
  
  private ArrayList<ArrayList<Edge>> vertexToEdge(ArrayList<ArrayList<Vertex>> vertices){
      
      ArrayList<ArrayList<Edge>> edges = new ArrayList<ArrayList<Edge>>(); 
      
      for(int i=0; i<vertices.size(); i++){ 
          ArrayList<Edge> temp = new ArrayList<Edge>(); 
          for(int c=1; c<vertices.get(i).size(); c++){
              Vertex x = vertices.get(i).get(c-1); 
              Vertex y = vertices.get(i).get(c);
              Edge e = new Edge(x, y, computeEuclideanDistance(x, y)); 
              temp.add(e);    
          }
          Vertex end = vertices.get(i).get(vertices.get(i).size()-1);
          Vertex start = vertices.get(i).get(0);
          Edge uv = new Edge(end, start, 
                             computeEuclideanDistance(end, start));
          temp.add(uv); 
          edges.add(temp);
      }
      return edges;
  }
//STUDENT CODE ENDS
