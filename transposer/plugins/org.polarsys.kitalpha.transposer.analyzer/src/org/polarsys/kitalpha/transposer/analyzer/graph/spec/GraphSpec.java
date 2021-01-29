/*******************************************************************************
 * Copyright (c) 2014, 2020 Thales Global Services S.A.S.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/

package org.polarsys.kitalpha.transposer.analyzer.graph.spec;

import org.polarsys.kitalpha.transposer.analyzer.graph.Edge;
import org.polarsys.kitalpha.transposer.analyzer.graph.GraphFactory;
import org.polarsys.kitalpha.transposer.analyzer.graph.Vertex;
import org.polarsys.kitalpha.transposer.analyzer.graph.impl.GraphImpl;

public class GraphSpec extends GraphImpl {

  /**
   * 
   * @see org.polarsys.kitalpha.transposer.analyzer.graph.impl.GraphImpl#addAdjacent(org.polarsys.kitalpha.transposer.analyzer.graph.Vertex,
   *      org.polarsys.kitalpha.transposer.analyzer.graph.Vertex, java.lang.Object)
   */
  @Override
  public <T> Edge<T> addAdjacent(Vertex<?> source, Vertex<?> target, T edgeContent) {
    return addAdjacent(source, target, edgeContent, false);
  }

  /**
   * 
   * @see org.polarsys.kitalpha.transposer.analyzer.graph.impl.GraphImpl#addAdjacent(org.polarsys.kitalpha.transposer.analyzer.graph.Vertex,
   *      org.polarsys.kitalpha.transposer.analyzer.graph.Vertex, java.lang.Object, boolean)
   */
  @Override
  public <T> Edge<T> addAdjacent(Vertex<?> source, Vertex<?> target, T edgeContent, boolean isCritical) {
    String edgeName = "edge_" + (getEdges().size() + 1); //$NON-NLS-1$;
    return addNamedAdjacent(source, target, edgeContent, edgeName, isCritical);
  }

  /**
   * 
   * @see org.polarsys.kitalpha.transposer.analyzer.graph.impl.GraphImpl#addNamedAdjacent(org.polarsys.kitalpha.transposer.analyzer.graph.Vertex,
   *      org.polarsys.kitalpha.transposer.analyzer.graph.Vertex, java.lang.Object, java.lang.String)
   */
  @Override
  public <T> Edge<T> addNamedAdjacent(Vertex<?> source, Vertex<?> target, T edgeContent, String edgeName) {
    return addNamedAdjacent(source, target, edgeContent, edgeName, false);
  }

  /**
   * 
   * @see org.polarsys.kitalpha.transposer.analyzer.graph.impl.GraphImpl#addNamedAdjacent(org.polarsys.kitalpha.transposer.analyzer.graph.Vertex,
   *      org.polarsys.kitalpha.transposer.analyzer.graph.Vertex, java.lang.Object, java.lang.String, boolean)
   */
  @Override
  public <T> Edge<T> addNamedAdjacent(Vertex<?> source, Vertex<?> target, T edgeContent, String edgeName, boolean isCritical) {
    Edge<T> newEdge = GraphFactory.eINSTANCE.<T> createEdge();
    newEdge.update(source, target, edgeContent, edgeName, isCritical);
    addEdge(newEdge);
    return newEdge;
  }

  /**
   * 
   * @see org.polarsys.kitalpha.transposer.analyzer.graph.impl.GraphImpl#addEdge(org.polarsys.kitalpha.transposer.analyzer.graph.Edge)
   */
  @Override
  public void addEdge(Edge<?> edge) {
    if (edge != null) {
		getEdges().add(edge);
	}
  }

  /**
   * 
   * @see org.polarsys.kitalpha.transposer.analyzer.graph.impl.GraphImpl#addVertex(org.polarsys.kitalpha.transposer.analyzer.graph.Vertex)
   */
  @Override
  public void addVertex(Vertex<?> vertex) {
    if (vertex != null) {
		getVertices().add(vertex);
	}
  }

}
