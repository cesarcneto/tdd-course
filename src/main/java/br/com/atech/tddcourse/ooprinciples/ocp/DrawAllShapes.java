package br.com.atech.tddcourse.ooprinciples.ocp;

import java.util.Set;

public class DrawAllShapes {

	public void drawAllShapes(final Set<Shape> shapes) {

		// 1 - Como garantir a ordem na chamada de draw sem violar o OCP?
		// 2 - Como desenhar apenas quadrados sem violar o OCP?

		for (final Shape s : shapes) {
			System.out.println(s.getClass().getSimpleName());
			s.draw();
		}
	}

}
