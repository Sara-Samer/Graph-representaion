import matplotlib.pyplot as plt
import networkx as nx

G = None
G = nx.DiGraph()
nEdges = int(input("Enter the number of edges: "))

for i in range(nEdges):
    a = input("Enter edge " + str(i + 1) + " src: ")
    b = input("Enter edge " + str(i + 1) + " dst: ")
    G.add_edge(a, b)

nx.draw(G, with_labels=True)
plt.show()
