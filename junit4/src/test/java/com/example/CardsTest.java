package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CardsTest {

  @Test
  public void cutAt1st() {
    final Cards cards = Cards.of(1,2,3,4,5,6);
    final Cards actual = cards.cutAt(1);
    assertThat(actual).isEqualTo(Cards.of(2,3,4,5,6,1));
  }


  @Test
  public void cutAt2nd() {
    final Cards cards = Cards.of(1, 2, 3, 4, 5, 6);

    final Cards actual = cards.cutAt(2);

    assertThat(actual).isEqualTo(Cards.of(3,4,5,6,1,2));
  }

  @Test
  public void equality_異なる() {
    final Cards cards = Cards.of(1, 2);
    final Cards another = Cards.of(2, 1);

    assertThat(cards).isNotEqualTo(another);
  }

  @Test
  public void equality_一致() {
    final Cards cards = Cards.of(1, 2,3,4);
    final Cards another = Cards.of(1,2,3,4);

    assertThat(cards).isEqualTo(another);
  }
}
