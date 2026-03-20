class Graph {

    constructor(data) {
        this.nodes = data.nodes;
        this.edges = data.edges;
    }
    
    addNode(id) {
        if (!this.nodes.find(n => n.id === id)) {
            this.nodes.push({ id });
        }
    }
    
    addEdge(source, target) {
        this.edges.push({ source, target });
    }
    
    getNeighbors(nodeId) {
        return this.edges
            .filter(e => e.source === nodeId || e.target === nodeId)
            .map(e => e.source === nodeId ? e.target : e.source);
    }
}

export default Graph;
