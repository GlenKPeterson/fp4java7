// Copyright (c) 2015-04-05 PlanBase Inc. & Glen Peterson
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.organicdesign.fp.permanent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnit4.class)
public class SequenceConcatenatedTest {

    @Test public void doubleNull() {
        assertArrayEquals(new Integer[0],
                          Sequence.ofArray().concat(null).toArray());

        assertArrayEquals(new Integer[0],
                          Sequence.ofArray().concat(Sequence.emptySequence()).toArray());

        assertArrayEquals(new Integer[0],
                          Sequence.ofArray().precat(null).toArray());

        assertArrayEquals(new Integer[0],
                          Sequence.ofArray().precat(Sequence.emptySequence()).toArray());
    }

    @Test public void prepend() {
        assertArrayEquals(new Integer[] { 5, 6, 7, 8, 9 },
                          Sequence.ofArray(5, 6, 7, 8, 9)
                                  .precat(null).toArray());

        assertArrayEquals(new Integer[] { 5, 6, 7, 8, 9 },
                          Sequence.ofArray(5, 6, 7, 8, 9)
                                  .precat(Sequence.emptySequence()).toArray());

        assertArrayEquals(new Integer[] { 4, 5, 6, 7, 8, 9 },
                          Sequence.ofArray(5, 6, 7, 8, 9)
                                  .precat(Sequence.ofArray(4)).toArray());

        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                          Sequence.ofArray(5, 6, 7, 8, 9)
                                  .precat(Sequence.ofArray(1, 2, 3, 4)).toArray());
    }

    @Test
    public void append() {
        assertArrayEquals(new Integer[] { 1, 2, 3, 4 },
                          Sequence.ofArray(1, 2, 3, 4)
                                  .concat(null).toArray());

        assertArrayEquals(new Integer[] { 1, 2, 3, 4 },
                          Sequence.ofArray(1, 2, 3, 4)
                                  .concat(Sequence.emptySequence()).toArray());

        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 },
                          Sequence.ofArray(1, 2, 3, 4)
                                  .concat(Sequence.ofArray(5)).toArray());

        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                          Sequence.ofArray(1, 2, 3, 4)
                                  .concat(Sequence.ofArray(5, 6, 7, 8, 9)).toArray());
    }

    @Test
    public void chainedPrependAppend() {
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                          Sequence.ofArray(5)                     //         5
                                  .precat(Sequence.ofArray(4))   //       4,5
                                  .concat(Sequence.ofArray(6))    //       4,5,6
                                  .precat(Sequence.ofArray(2, 3)) //   2,3,4,5,6
                                  .concat(Sequence.ofArray(7, 8))  //   2,3,4,5,6,7,8
                                  .precat(Sequence.ofArray(1))   // 1,2,3,4,5,6,7,8
                                  .concat(Sequence.ofArray(9))    // 1,2,3,4,5,6,7,8,9
                                  .toArray());

        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                          Sequence.ofArray(5)
                                  .precat(null).precat(null).precat(null).precat(null)
                                  .precat(Sequence.emptySequence()).precat(Sequence.emptySequence())
                                  .precat(null)
                                  .concat(Sequence.emptySequence()).concat(Sequence.emptySequence())
                                  .concat(null).concat(null).concat(null).concat(null).concat(null)
                                  .precat(Sequence.ofArray(4))
                                  .precat(null).precat(null).precat(null).precat(null)
                                  .precat(Sequence.emptySequence()).precat(Sequence.emptySequence())
                                  .precat(null)
                                  .concat(Sequence.emptySequence()).concat(Sequence.emptySequence())
                                  .concat(null).concat(null).concat(null).concat(null).concat(null)
                                  .concat(Sequence.ofArray(6))
                                  .precat(null).precat(null).precat(null).precat(null)
                                  .precat(Sequence.emptySequence()).precat(Sequence.emptySequence())
                                  .precat(null)
                                  .concat(Sequence.emptySequence()).concat(Sequence.emptySequence())
                                  .concat(null).concat(null).concat(null).concat(null).concat(null)
                                  .precat(Sequence.ofArray(2, 3))
                                  .precat(null).precat(null).precat(null).precat(null)
                                  .precat(Sequence.emptySequence()).precat(Sequence.emptySequence())
                                  .precat(null)
                                  .concat(Sequence.emptySequence()).concat(Sequence.emptySequence())
                                  .concat(null).concat(null).concat(null).concat(null).concat(null)
                                  .concat(Sequence.ofArray(7, 8))
                                  .precat(null).precat(null).precat(null).precat(null)
                                  .precat(Sequence.emptySequence()).precat(Sequence.emptySequence())
                                  .precat(null)
                                  .concat(Sequence.emptySequence()).concat(Sequence.emptySequence())
                                  .concat(null).concat(null).concat(null).concat(null).concat(null)
                                  .precat(Sequence.ofArray(1))
                                  .precat(null).precat(null).precat(null).precat(null)
                                  .precat(Sequence.emptySequence()).precat(Sequence.emptySequence())
                                  .precat(null)
                                  .concat(Sequence.emptySequence()).concat(Sequence.emptySequence())
                                  .concat(null).concat(null).concat(null).concat(null).concat(null)
                                  .concat(Sequence.ofArray(9))
                                  .precat(null).precat(null).precat(null).precat(null)
                                  .precat(Sequence.emptySequence()).precat(Sequence.emptySequence())
                                  .precat(null)
                                  .concat(Sequence.emptySequence()).concat(Sequence.emptySequence())
                                  .concat(null).concat(null).concat(null).concat(null).concat(null)
                                  .toArray());
    }
}
