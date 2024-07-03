package graphs;

import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Shape;
import guru.nidi.graphviz.attribute.Style;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Factory;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GraphVisualizer {

    public static void visualizeGraph(Graph graph, String title) {
        System.setProperty("java.awt.headless", "false");
        MutableGraph mutableGraph = Factory.mutGraph("exampleGraph").setDirected(true);

        for (Vertex vertex :  graph.getVertices()) {
            Color fillColor = vertex.visited ? Color.GRAY80 : Color.WHITE;
            String label = String.format("ID: %d\nDist: %d", vertex.id, vertex.distance);
            MutableNode node = Factory.mutNode(String.valueOf(vertex.id))
                                      .add(Label.of(label))
                                      .add(Shape.ELLIPSE)
                                      .add(Style.FILLED.and(Style.SOLID))
                                      .add(fillColor.fill())
                                      .add(Color.BLACK);
            for (Vertex dest : vertex.neighbors) {
                Color edgeColor = dest.parent == vertex ? Color.RED : Color.BLACK;
                node.addLink(Factory.to(Factory.mutNode(String.valueOf(dest.id))).add(edgeColor));
            }
            mutableGraph.add(node);
        }

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Graphviz.fromGraph(mutableGraph).height(700).render(Format.PNG).toOutputStream(outputStream);

            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            BufferedImage image = ImageIO.read(inputStream);
            showImage(image, title);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showImage(BufferedImage image, String title) {
        JFrame frame = new JFrame(title);
        frame.setSize(new Dimension(image.getWidth(), image.getHeight()));
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Graph myGraph = new Graph(5);
        myGraph.connectAll();
        myGraph.depthFirstSearchRecursive(0);
        visualizeGraph(myGraph, "Graph");
    }
}