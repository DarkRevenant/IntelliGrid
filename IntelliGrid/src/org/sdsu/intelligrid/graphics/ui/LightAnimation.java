// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.R;
import org.sdsu.intelligrid.graphics.Sprite;
import org.sdsu.intelligrid.simulation.Simulation.SimInfo;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.Vector2f;

public class LightAnimation {

	private static enum OrbTypes {
		BLUE, GREEN;
	}

	public static enum LightStates {
		OFF('0'), RED('1'), BLUE('2'), DIMMER_BLUE('3'), DIMMEST_BLUE('4'), GREEN(
				'5'), DIMMER_GREEN('6'), DIMMEST_GREEN('7');

		public final char signal;

		private LightStates(final char signal) {
			this.signal = signal;
		}
	}

	private static enum Junctions {
		ABC, B_BRANCH, B_GEN, CDE, D_BRANCH, D_BRANCH_2, D_GEN, EFG, F_BRANCH, F_BRANCH_2, F_GEN, IHG, H_BRANCH, H_GEN, KJI, J_BRANCH, J_GEN, MLK, L_BRANCH, L_GEN;

		private float path1 = 0f;
		private float path2 = 0f;
		private float path3 = 0f;

		private int advance(final float path1, final float path2,
				final float path3) {
			this.path1 += path1;
			this.path2 += path2;
			this.path3 += path3;
			if ((this.path1 >= this.path2 || path2 <= 0f)
					&& (this.path1 >= this.path3 || path3 <= 0f)) {
				this.path1 -= path1 + path2 + path3;
				return 1;
			} else if ((this.path2 >= this.path1 || path1 <= 0f)
					&& (this.path2 >= this.path3 || path3 <= 0f)) {
				this.path2 -= path1 + path2 + path3;
				return 2;
			} else {
				this.path3 -= path1 + path2 + path3;
				return 3;
			}
		}
	}

	public static enum LightStrands {
		SEGMENT_A(new Segment(LEDLayout.segmentA, 1f)), SEGMENT_B(new Segment(
				LEDLayout.segmentB, 1f)), SEGMENT_B_BRANCH_1(new Segment(
				LEDLayout.segmentBbranch1, 1f)), SEGMENT_B_BRANCH_2(
				new Segment(LEDLayout.segmentBbranch2, 1f)), SEGMENT_B_BRANCH_3(
				new Segment(LEDLayout.segmentBbranch3, 1f)), SEGMENT_C(
				new Segment(LEDLayout.segmentC, 1f)), SEGMENT_D(new Segment(
				LEDLayout.segmentD, 1f)), SEGMENT_D_2(new Segment(
				LEDLayout.segmentD2, 1f)), SEGMENT_D_BRANCH_1(new Segment(
				LEDLayout.segmentDbranch1, 1f)), SEGMENT_D_BRANCH_2(
				new Segment(LEDLayout.segmentDbranch2, 1f)), SEGMENT_D_BRANCH_3(
				new Segment(LEDLayout.segmentDbranch3, 1f)), SEGMENT_E(
				new Segment(LEDLayout.segmentE, 1f)), SEGMENT_F(new Segment(
				LEDLayout.segmentF, 1f)), SEGMENT_F_2(new Segment(
				LEDLayout.segmentF2, 1f)), SEGMENT_F_BRANCH_1(new Segment(
				LEDLayout.segmentFbranch1, 1f)), SEGMENT_F_BRANCH_2(
				new Segment(LEDLayout.segmentFbranch2, 1f)), SEGMENT_F_BRANCH_3(
				new Segment(LEDLayout.segmentFbranch3, 1f)), SEGMENT_G(
				new Segment(LEDLayout.segmentG, 1f)), SEGMENT_H(new Segment(
				LEDLayout.segmentH, 1f)), SEGMENT_H_BRANCH_1(new Segment(
				LEDLayout.segmentHbranch1, 1f)), SEGMENT_H_BRANCH_2(
				new Segment(LEDLayout.segmentHbranch2, 1f)), SEGMENT_I(
				new Segment(LEDLayout.segmentI, 1f)), SEGMENT_J(new Segment(
				LEDLayout.segmentJ, 1f)), SEGMENT_J_BRANCH_1(new Segment(
				LEDLayout.segmentJbranch1, 1f)), SEGMENT_J_BRANCH_2(
				new Segment(LEDLayout.segmentJbranch2, 1f)), SEGMENT_K(
				new Segment(LEDLayout.segmentK, 1f)), SEGMENT_L(new Segment(
				LEDLayout.segmentL, 1f)), SEGMENT_L_BRANCH_1(new Segment(
				LEDLayout.segmentLbranch1, 1f)), SEGMENT_L_BRANCH_2(
				new Segment(LEDLayout.segmentLbranch2, 1f)), SEGMENT_M(
				new Segment(LEDLayout.segmentM, 1f)), SEGMENT_W(new Segment(
				LEDLayout.segmentYW, 1f)), SEGMENT_X(new Segment(
				LEDLayout.segmentX, 1f)), SWITCH_ABC(new BaseStrand(
				LEDLayout.switchABC)), SWITCH_CDE(new BaseStrand(
				LEDLayout.switchCDE)), SWITCH_EFG(new BaseStrand(
				LEDLayout.switchEFG)), SWITCH_IHG(new BaseStrand(
				LEDLayout.switchIHG)), SWITCH_KJI(new BaseStrand(
				LEDLayout.switchKJI)), SWITCH_MLK(new BaseStrand(
				LEDLayout.switchMLK)), TRANSFORMER_B(new BaseStrand(
				LEDLayout.transformerB)), TRANSFORMER_D(new BaseStrand(
				LEDLayout.transformerD)), TRANSFORMER_F(new BaseStrand(
				LEDLayout.transformerF)), TRANSFORMER_H(new BaseStrand(
				LEDLayout.transformerH)), TRANSFORMER_J(new BaseStrand(
				LEDLayout.transformerJ)), TRANSFORMER_L(new BaseStrand(
				LEDLayout.transformerL)), TIE(new BaseStrand(LEDLayout.tie));

		public final List<Integer> modelLEDs;
		public final Strand strand;

		private LightStrands(final Strand strand) {
			this.strand = strand;
			modelLEDs = strand.getLEDs();
		}
	}

	private static final class LEDLayout {
		private static final List<Integer> segmentA = Arrays.asList(1, 2, 3, 4,
				5);
		private static final List<Integer> switchABC = Arrays.asList(4, 5, 6);
		private static final List<Integer> segmentB = Arrays
				.asList(7, 8, 9, 10);
		private static final List<Integer> transformerB = Arrays.asList(8);
		private static final List<Integer> segmentBbranch1 = Arrays.asList(11,
				12);
		private static final List<Integer> segmentBbranch2 = Arrays.asList(13,
				14);
		private static final List<Integer> segmentBbranch3 = Arrays.asList(15,
				16);
		private static final List<Integer> segmentC = Arrays.asList(6, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27);
		private static final List<Integer> switchCDE = Arrays
				.asList(26, 27, 28);
		private static final List<Integer> segmentD = Arrays.asList(29, 30, 31,
				32, 33, 34, 35, 36, 37, 38);
		private static final List<Integer> segmentD2 = Arrays
				.asList(41, 42, 43);
		private static final List<Integer> transformerD = Arrays.asList(36);
		private static final List<Integer> segmentDbranch1 = Arrays.asList(39,
				40);
		private static final List<Integer> segmentDbranch2 = Arrays.asList(44,
				45);
		private static final List<Integer> segmentDbranch3 = Arrays.asList(46,
				47, 48, 49);
		private static final List<Integer> segmentE = Arrays.asList(28, 50, 51,
				52, 53, 54, 55, 56);
		private static final List<Integer> switchEFG = Arrays
				.asList(55, 56, 57);
		private static final List<Integer> segmentF = Arrays.asList(58, 59, 60,
				61);
		private static final List<Integer> segmentF2 = Arrays.asList(65, 66,
				67, 68, 69, 70);
		private static final List<Integer> transformerF = Arrays.asList(59);
		private static final List<Integer> segmentFbranch1 = Arrays.asList(62,
				63, 64);
		private static final List<Integer> segmentFbranch2 = Arrays.asList(71,
				72, 73);
		private static final List<Integer> segmentFbranch3 = Arrays.asList(74,
				75, 76);
		private static final List<Integer> segmentG = Arrays.asList(57, 77, 78,
				79, 80, 81, 82, 83, 84, 85, 86, 87);
		private static final List<Integer> tie = Arrays.asList(81, 82);
		private static final List<Integer> switchIHG = Arrays
				.asList(89, 88, 87);
		private static final List<Integer> segmentH = Arrays.asList(90, 91, 92,
				93, 94, 95, 96, 97);
		private static final List<Integer> transformerH = Arrays.asList(92);
		private static final List<Integer> segmentHbranch1 = Arrays.asList(98,
				99, 100, 101);
		private static final List<Integer> segmentHbranch2 = Arrays.asList(102,
				103, 104, 105, 106);
		private static final List<Integer> segmentI = Arrays.asList(116, 115,
				114, 113, 112, 111, 110, 109, 108, 107, 89, 88);
		private static final List<Integer> switchKJI = Arrays.asList(118, 117,
				116);
		private static final List<Integer> segmentJ = Arrays.asList(119, 120,
				121, 122, 123, 124);
		private static final List<Integer> transformerJ = Arrays.asList(121);
		private static final List<Integer> segmentJbranch1 = Arrays.asList(125,
				126, 127);
		private static final List<Integer> segmentJbranch2 = Arrays.asList(128,
				129, 130);
		private static final List<Integer> segmentK = Arrays.asList(135, 134,
				133, 132, 131, 118, 117);
		private static final List<Integer> switchMLK = Arrays.asList(137, 136,
				135);
		private static final List<Integer> segmentL = Arrays.asList(138, 139,
				140, 141, 142, 143, 144, 145);
		private static final List<Integer> transformerL = Arrays.asList(141);
		private static final List<Integer> segmentLbranch1 = Arrays.asList(146,
				147);
		private static final List<Integer> segmentLbranch2 = Arrays.asList(148,
				149, 150, 151);
		private static final List<Integer> segmentM = Arrays.asList(154, 153,
				152, 137, 136);
		private static final List<Integer> segmentYW = Arrays.asList(167, 166,
				165, 164, 163, 162, 161, 160, 159, 158, 157, 156, 155);
		private static final List<Integer> segmentX = Arrays.asList(174, 173,
				172, 171, 170, 169, 168, 175, 176, 177);
	}

	protected static final Map<Integer, LightStates> states = new HashMap<>();

	public static LightStates getState(final int led) {
		final LightStates state = states.get(led);
		if (state == null) {
			return LightStates.OFF;
		} else {
			return state;
		}
	}

	private static class Orb {

		private static final float FADE_TIME = 0.5f;

		private Sprite sprite;
		private OrbTypes type;
		private float progress = 0f;
		private int fromLED;
		private int toLED;
		private Segment segment;
		public boolean fading = false;
		public boolean forward = true;
		private float alpha = 1f;

		private Orb(final OrbTypes type, Segment segment, final int from,
				final int to) {
			this.type = type;
			this.segment = segment;
			fromLED = from;
			toLED = to;

			final Color color;
			if (type == OrbTypes.BLUE) {
				color = new Color(70, 255, 244);
			} else {
				color = new Color(111, 255, 0);
			}

			sprite = new Sprite(MainUI.ledPositionMap.get(from), 1, 0f,
					new Vector2f(1f, 1f), color, R.drawable.orb);

			Global.getRenderer().addDrawable(sprite);
		}

		public float advance(final float distance) {
            if (Math.abs(MainUI.ledPositionMap.get(toLED).x - MainUI.ledPositionMap.get(fromLED).x) <= OFF_THRESHOLD && Math.abs(MainUI.ledPositionMap.get(toLED).y - MainUI.ledPositionMap.get(fromLED).y) <= OFF_THRESHOLD) {
                return distance;
            }

            final float dist = Vector2f.sub(MainUI.ledPositionMap.get(toLED),
					MainUI.ledPositionMap.get(fromLED), null).length();
			progress += distance / dist;

			sprite.setLocation(Vector2f.linear(
					MainUI.ledPositionMap.get(fromLED),
					MainUI.ledPositionMap.get(toLED), progress));

			if (progress > 1f) {
				return (progress - 1f) * dist;
			} else {
				return 0f;
			}
		}

		public boolean fade(final float amount) {
			alpha -= amount / FADE_TIME;
			if (alpha <= 0f) {
				destroy();
				return true;
			}
			sprite.setColor(new Color(sprite.getColor().getRed(), sprite
					.getColor().getGreen(), sprite.getColor().getBlue(),
					(int) (alpha * 255f)));
			return false;
		}

		public void destroy() {
			Global.getRenderer().removeDrawable(sprite);
		}

		public OrbTypes getType() {
			return type;
		}

		public int getFrom() {
			return fromLED;
		}

		public int getTo() {
			return toLED;
		}

		public void setFrom(final int fromLED) {
			this.fromLED = fromLED;
			progress = 0f;
		}

		public void setTo(final int toLED) {
			this.toLED = toLED;
			progress = 0f;
		}

		public Segment getSegment() {
			return segment;
		}

		public void setSegment(Segment segment) {
			this.segment = segment;
		}
	}

	public static interface Strand {

		public List<Integer> getLEDs();
	}

	public static class BaseStrand implements Strand {

		protected final List<Integer> leds;

		public BaseStrand(final List<Integer> leds) {
			this.leds = leds;
			for (int led : leds) {
				states.put(led, LightStates.OFF);
			}
		}

		@Override
		public List<Integer> getLEDs() {
			return leds;
		}
	}

	public static final class Segment extends BaseStrand {

		private final float orbFlowScale;
		private float gen = 0f;
		private float genGreen = 0f;
		private float flow = 0f;

		public Segment(final List<Integer> leds, final float orbFlowScale) {
			super(leds);
			this.orbFlowScale = orbFlowScale;
		}

		public int advance(final float blueFlow, final float greenFlow) {
			gen += (blueFlow + greenFlow) * GEN_SCALE * orbFlowScale;
			genGreen += greenFlow * GEN_SCALE * orbFlowScale;

			if (gen >= 1f && genGreen >= 1f) {
				gen -= 1f;
				genGreen -= 1f;
				return 2;
			} else if (gen >= 1f && genGreen < 1f) {
				gen -= 1f;
				return 1;
			} else {
				return 0;
			}
		}

		public void setFlow(final float flow) {
			this.flow = flow;
		}

		public float getFlow() {
			return flow * orbFlowScale;
		}
	}

	private static float jitter() {
		return (float) Math.random() * 0.05f;
	}

	private static final float OFF_THRESHOLD = 0.0001f;

	private static final float GEN_SCALE = 40f;
	private static final float FLOW_SCALE = 5f;

	private final List<Orb> orbs = new ArrayList<>();

	public void advance(final float amount) {
        //Logger.getGlobal().log(Level.SEVERE, "" + orbs.size() + " orbs");
		Iterator<Orb> iter = orbs.iterator();
		while (iter.hasNext()) {
			Orb orb = iter.next();

			float adv = 0f;
			while (true) {
				if (orb.fading) {
					if (orb.fade(amount)) {
						iter.remove();
					}
					break;
				}

				final Segment segment = orb.getSegment();
                if (Math.abs(segment.getFlow()) <= OFF_THRESHOLD) {
                    orb.fading = true;
                    continue;
                }
                if ((segment.getFlow() < 0f && orb.forward) || (segment.getFlow() > 0f && !orb.forward)) {
                    orb.forward = !orb.forward;
                }
				adv = orb
						.advance(Math.abs(segment.getFlow()) * amount * FLOW_SCALE + adv);
				if (adv <= 0f) {
					break;
				}

				final int index = segment.getLEDs().indexOf(orb.getTo());
				if (orb.forward) {
					if (index < segment.getLEDs().size() - 1) {
						orb.setFrom(orb.getTo());
						orb.setTo(segment.getLEDs().get(index + 1));
						continue;
					}
				} else {
					if (index > 0) {
						orb.setFrom(orb.getTo());
						orb.setTo(segment.getLEDs().get(index - 1));
						continue;
					}
				}

				Segment nextSegment = null;

				if (segment == LightStrands.SEGMENT_A.strand && orb.forward) {
					final float b = Math.max(getFlow(LightStrands.SEGMENT_B), 0f);
					final float c = Math.max(getFlow(LightStrands.SEGMENT_C), 0f);
					final int dir = Junctions.ABC.advance(b, c, 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_B.strand;
					} else if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_C.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_A.strand && !orb.forward) {
					orb.fading = true;
					continue;
				}

				if (segment == LightStrands.SEGMENT_B.strand && orb.forward) {
					final int dir = Junctions.B_BRANCH.advance(1f + jitter(),
							1f + jitter(), 1f + jitter());
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_B_BRANCH_1.strand;
					} else if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_B_BRANCH_2.strand;
					} else {
						nextSegment = (Segment) LightStrands.SEGMENT_B_BRANCH_3.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_B.strand && !orb.forward) {
					if (getFlow(LightStrands.SEGMENT_C) > OFF_THRESHOLD) {
						nextSegment = (Segment) LightStrands.SEGMENT_C.strand;
						orb.forward = true;
					} else {
						orb.fading = true; // sanity
						continue;
					}
				}

				if ((segment == LightStrands.SEGMENT_B_BRANCH_1.strand
						|| segment == LightStrands.SEGMENT_B_BRANCH_2.strand || segment == LightStrands.SEGMENT_B_BRANCH_3.strand)
						&& orb.forward) {
					orb.fading = true;
					continue;
				}

				if ((segment == LightStrands.SEGMENT_B_BRANCH_1.strand
						|| segment == LightStrands.SEGMENT_B_BRANCH_2.strand || segment == LightStrands.SEGMENT_B_BRANCH_3.strand)
						&& !orb.forward) {
					nextSegment = (Segment) LightStrands.SEGMENT_B.strand;
				}

				if (segment == LightStrands.SEGMENT_C.strand && orb.forward) {
					final float d = Math.max(getFlow(LightStrands.SEGMENT_D), 0f);
					final float e = Math.max(getFlow(LightStrands.SEGMENT_E), 0f);
					final int dir = Junctions.CDE.advance(0f, d, e);
					if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_D.strand;
					} else if (dir == 3) {
						nextSegment = (Segment) LightStrands.SEGMENT_E.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_C.strand && !orb.forward) {
					if (getFlow(LightStrands.SEGMENT_B) > OFF_THRESHOLD) {
						nextSegment = (Segment) LightStrands.SEGMENT_B.strand;
						orb.forward = true;
					} else {
						orb.fading = true; // sanity
						continue;
					}
				}

				if (segment == LightStrands.SEGMENT_D.strand && orb.forward) {
					final int dir = Junctions.D_BRANCH.advance(1f + jitter(),
							1f + jitter(), 1f + jitter());
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_D_BRANCH_1.strand;
					} else {
						nextSegment = (Segment) LightStrands.SEGMENT_D_2.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_D.strand && !orb.forward) {
                    final float c = -Math.min(getFlow(LightStrands.SEGMENT_C), 0f);
                    final float e = Math.max(getFlow(LightStrands.SEGMENT_E), 0f);
                    final int dir = Junctions.CDE.advance(c, 0f, e);
                    if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_C.strand;
					} else if (dir == 3) {
						nextSegment = (Segment) LightStrands.SEGMENT_E.strand;
						orb.forward = true;
					}
				}

				if (segment == LightStrands.SEGMENT_D_2.strand && orb.forward) {
					final int dir = Junctions.D_BRANCH_2.advance(1f + jitter(),
							1f + jitter(), 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_D_BRANCH_2.strand;
					} else {
						nextSegment = (Segment) LightStrands.SEGMENT_D_BRANCH_3.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_D_2.strand && !orb.forward) {
					nextSegment = (Segment) LightStrands.SEGMENT_D.strand;
				}

				if ((segment == LightStrands.SEGMENT_D_BRANCH_1.strand
						|| segment == LightStrands.SEGMENT_D_BRANCH_2.strand || segment == LightStrands.SEGMENT_D_BRANCH_3.strand)
						&& orb.forward) {
					orb.fading = true;
					continue;
				}

				if (segment == LightStrands.SEGMENT_D_BRANCH_1.strand && !orb.forward) {
					nextSegment = (Segment) LightStrands.SEGMENT_D.strand;
				}

                if ((segment == LightStrands.SEGMENT_D_BRANCH_2.strand || segment == LightStrands.SEGMENT_D_BRANCH_3.strand)
                        && !orb.forward) {
                    nextSegment = (Segment) LightStrands.SEGMENT_D_2.strand;
                }

				if (segment == LightStrands.SEGMENT_E.strand && orb.forward) {
					final float f = Math.max(getFlow(LightStrands.SEGMENT_F), 0f);
					final float g = Math.max(getFlow(LightStrands.SEGMENT_G), 0f);
					final int dir = Junctions.EFG.advance(0f, f, g);
					if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_F.strand;
					} else if (dir == 3) {
						nextSegment = (Segment) LightStrands.SEGMENT_G.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_E.strand && !orb.forward) {
					final float c = -Math.min(getFlow(LightStrands.SEGMENT_C), 0f);
					final float d = Math.max(getFlow(LightStrands.SEGMENT_D), 0f);
					final int dir = Junctions.CDE.advance(c, d, 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_C.strand;
					} else if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_D.strand;
						orb.forward = true;
					}
				}

				if (segment == LightStrands.SEGMENT_F.strand && orb.forward) {
					final int dir = Junctions.F_BRANCH.advance(1f + jitter(),
							1f + jitter(), 1f + jitter());
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_F_2.strand;
					} else {
						nextSegment = (Segment) LightStrands.SEGMENT_F_BRANCH_1.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_F.strand && !orb.forward) {
                    final float e = -Math.min(getFlow(LightStrands.SEGMENT_E), 0f);
                    final float g = Math.max(getFlow(LightStrands.SEGMENT_G), 0f);
                    final int dir = Junctions.EFG.advance(e, 0f, g);
                    if (dir == 1) {
                        nextSegment = (Segment) LightStrands.SEGMENT_E.strand;
                    } else if (dir == 3) {
                        nextSegment = (Segment) LightStrands.SEGMENT_G.strand;
                        orb.forward = true;
                    }
				}

				if (segment == LightStrands.SEGMENT_F_2.strand && orb.forward) {
					final int dir = Junctions.F_BRANCH_2.advance(1f + jitter(),
							1f + jitter(), 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_F_BRANCH_2.strand;
					} else {
						nextSegment = (Segment) LightStrands.SEGMENT_F_BRANCH_3.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_F_2.strand && !orb.forward) {
					nextSegment = (Segment) LightStrands.SEGMENT_F.strand;
				}

				if ((segment == LightStrands.SEGMENT_F_BRANCH_1.strand
						|| segment == LightStrands.SEGMENT_F_BRANCH_2.strand || segment == LightStrands.SEGMENT_F_BRANCH_3.strand)
						&& orb.forward) {
					orb.fading = true;
					continue;
				}

				if (segment == LightStrands.SEGMENT_F_BRANCH_1.strand && !orb.forward) {
					nextSegment = (Segment) LightStrands.SEGMENT_F.strand;
				}

                if ((segment == LightStrands.SEGMENT_F_BRANCH_2.strand || segment == LightStrands.SEGMENT_F_BRANCH_3.strand)
                        && !orb.forward) {
                    nextSegment = (Segment) LightStrands.SEGMENT_F_2.strand;
                }

				if (segment == LightStrands.SEGMENT_G.strand && orb.forward) {
					final float i = -Math.min(getFlow(LightStrands.SEGMENT_I), 0f);
					final float h = Math.max(getFlow(LightStrands.SEGMENT_H), 0f);
					final int dir = Junctions.IHG.advance(i, h, 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_I.strand;
						orb.forward = false;
					} else if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_H.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_G.strand && !orb.forward) {
					final float e = -Math.min(getFlow(LightStrands.SEGMENT_E), 0f);
					final float f = Math.max(getFlow(LightStrands.SEGMENT_F), 0f);
					final int dir = Junctions.EFG.advance(e, f, 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_E.strand;
					} else if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_F.strand;
						orb.forward = true;
					}
				}

				if (segment == LightStrands.SEGMENT_H.strand && orb.forward) {
					final int dir = Junctions.H_BRANCH.advance(1f + jitter(),
							1f + jitter(), 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_H_BRANCH_1.strand;
					} else {
						nextSegment = (Segment) LightStrands.SEGMENT_H_BRANCH_2.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_H.strand && !orb.forward) {
                    final float i = -Math.min(getFlow(LightStrands.SEGMENT_I), 0f);
                    final float g = -Math.min(getFlow(LightStrands.SEGMENT_G), 0f);
                    final int dir = Junctions.IHG.advance(i, 0f, g);
                    if (dir == 1) {
                        nextSegment = (Segment) LightStrands.SEGMENT_I.strand;
                    } else if (dir == 3) {
                        nextSegment = (Segment) LightStrands.SEGMENT_G.strand;
                    }
				}

				if ((segment == LightStrands.SEGMENT_H_BRANCH_1.strand || segment == LightStrands.SEGMENT_H_BRANCH_2.strand)
						&& orb.forward) {
					orb.fading = true;
					continue;
				}

				if ((segment == LightStrands.SEGMENT_H_BRANCH_1.strand || segment == LightStrands.SEGMENT_H_BRANCH_2.strand)
						&& !orb.forward) {
					nextSegment = (Segment) LightStrands.SEGMENT_H.strand;
				}

				if (segment == LightStrands.SEGMENT_I.strand && orb.forward) {
					final float h = Math.max(getFlow(LightStrands.SEGMENT_H), 0f);
					final float g = -Math.min(getFlow(LightStrands.SEGMENT_G), 0f);
					final int dir = Junctions.IHG.advance(0f, h, g);
					if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_H.strand;
					} else if (dir == 3) {
						nextSegment = (Segment) LightStrands.SEGMENT_G.strand;
						orb.forward = false;
					}
				}

				if (segment == LightStrands.SEGMENT_I.strand && !orb.forward) {
					final float k = -Math.min(getFlow(LightStrands.SEGMENT_K), 0f);
					final float j = Math.max(getFlow(LightStrands.SEGMENT_J), 0f);
					final int dir = Junctions.KJI.advance(k, j, 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_K.strand;
					} else if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_J.strand;
						orb.forward = true;
					}
				}

				if (segment == LightStrands.SEGMENT_J.strand && orb.forward) {
					final int dir = Junctions.J_BRANCH.advance(1f + jitter(),
							1f + jitter(), 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_J_BRANCH_1.strand;
					} else {
						nextSegment = (Segment) LightStrands.SEGMENT_J_BRANCH_2.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_J.strand && !orb.forward) {
                    final float k = -Math.min(getFlow(LightStrands.SEGMENT_K), 0f);
                    final float i = Math.max(getFlow(LightStrands.SEGMENT_I), 0f);
                    final int dir = Junctions.KJI.advance(k, 0f, i);
                    if (dir == 1) {
                        nextSegment = (Segment) LightStrands.SEGMENT_K.strand;
                    } else if (dir == 3) {
                        nextSegment = (Segment) LightStrands.SEGMENT_I.strand;
                        orb.forward = true;
                    }
				}

				if ((segment == LightStrands.SEGMENT_J_BRANCH_1.strand || segment == LightStrands.SEGMENT_J_BRANCH_2.strand)
						&& orb.forward) {
					orb.fading = true;
					continue;
				}

				if ((segment == LightStrands.SEGMENT_J_BRANCH_1.strand || segment == LightStrands.SEGMENT_J_BRANCH_2.strand)
						&& !orb.forward) {
					nextSegment = (Segment) LightStrands.SEGMENT_J.strand;
				}

				if (segment == LightStrands.SEGMENT_K.strand && orb.forward) {
					final float j = Math.max(getFlow(LightStrands.SEGMENT_J), 0f);
					final float i = Math.max(getFlow(LightStrands.SEGMENT_I), 0f);
					final int dir = Junctions.KJI.advance(0f, j, i);
					if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_J.strand;
					} else if (dir == 3) {
						nextSegment = (Segment) LightStrands.SEGMENT_I.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_K.strand && !orb.forward) {
					if (getFlow(LightStrands.SEGMENT_L) > OFF_THRESHOLD) {
						nextSegment = (Segment) LightStrands.SEGMENT_L.strand;
						orb.forward = true;
					} else {
						orb.fading = true; // sanity
						continue;
					}
				}

				if (segment == LightStrands.SEGMENT_L.strand && orb.forward) {
					final int dir = Junctions.L_BRANCH.advance(1f + jitter(),
							1f + jitter(), 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_L_BRANCH_1.strand;
					} else {
						nextSegment = (Segment) LightStrands.SEGMENT_L_BRANCH_2.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_L.strand && !orb.forward) {
					if (getFlow(LightStrands.SEGMENT_K) > OFF_THRESHOLD) {
						nextSegment = (Segment) LightStrands.SEGMENT_K.strand;
						orb.forward = true;
					} else {
						orb.fading = true; // sanity
						continue;
					}
				}

				if ((segment == LightStrands.SEGMENT_L_BRANCH_1.strand || segment == LightStrands.SEGMENT_L_BRANCH_2.strand)
						&& orb.forward) {
					orb.fading = true;
					continue;
				}

				if ((segment == LightStrands.SEGMENT_L_BRANCH_1.strand || segment == LightStrands.SEGMENT_L_BRANCH_2.strand)
						&& !orb.forward) {
					nextSegment = (Segment) LightStrands.SEGMENT_L.strand;
				}

				if (segment == LightStrands.SEGMENT_M.strand && orb.forward) {
					final float l = Math.max(getFlow(LightStrands.SEGMENT_L), 0f);
					final float k = Math.max(getFlow(LightStrands.SEGMENT_K), 0f);
					final int dir = Junctions.MLK.advance(l, k, 0f);
					if (dir == 1) {
						nextSegment = (Segment) LightStrands.SEGMENT_L.strand;
					} else if (dir == 2) {
						nextSegment = (Segment) LightStrands.SEGMENT_K.strand;
					}
				}

				if (segment == LightStrands.SEGMENT_M.strand && !orb.forward) {
					orb.fading = true;
					continue;
				}

				if (segment == LightStrands.SEGMENT_X.strand) {
					orb.fading = true;
					continue;
				}

				if (segment == LightStrands.SEGMENT_W.strand) {
					orb.fading = true;
					continue;
				}

				if (nextSegment != null) {
					orb.setSegment(nextSegment);
					if (orb.forward) {
						orb.setFrom(orb.getTo());
						orb.setTo(nextSegment.getLEDs().get(0));
					} else {
						orb.setFrom(orb.getTo());
						orb.setTo(nextSegment.getLEDs().get(
								nextSegment.getLEDs().size() - 1));
					}
				} else {
                    orb.fading = true;
                    continue;
				}
			}
		}

		if ((float) SimInfo.trA > OFF_THRESHOLD) {
			final float flow = (float) SimInfo.trA * amount;
			final float greenFlow = (float) (SimInfo.PowPlant + SimInfo.WindTurbines)
					* (float) (SimInfo.trA / (SimInfo.trA + SimInfo.trM + SimInfo.BatteryStorage * SimInfo.GenScale))
					* amount * (float) SimInfo.GenScale;
			final float blueFlow = flow - greenFlow;

			final Segment strand = (Segment) LightStrands.SEGMENT_A.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_A));

			final int type = strand.advance(blueFlow, greenFlow);
			final OrbTypes orbType;
			if (type == 2) {
				orbType = OrbTypes.GREEN;
			} else {
				orbType = OrbTypes.BLUE;
			}

			if (type > 0) {
				orbs.add(new Orb(orbType, strand, strand.getLEDs().get(0),
						strand.getLEDs().get(1)));
			}
		}

		if ((float) SimInfo.trB > OFF_THRESHOLD) {
			Segment strand = (Segment) LightStrands.SEGMENT_B.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_B));
			strand = (Segment) LightStrands.SEGMENT_B_BRANCH_1.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_B_BRANCH_1));
			strand = (Segment) LightStrands.SEGMENT_B_BRANCH_2.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_B_BRANCH_2));
			strand = (Segment) LightStrands.SEGMENT_B_BRANCH_3.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_B_BRANCH_3));
		}

		if ((float) SimInfo.trC > OFF_THRESHOLD) {
			final Segment strand = (Segment) LightStrands.SEGMENT_C.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_C));
		}

		if ((float) SimInfo.trD > OFF_THRESHOLD) {
            Segment strand = (Segment) LightStrands.SEGMENT_D.strand;
            strand.setFlow(getFlow(LightStrands.SEGMENT_D));
            strand = (Segment) LightStrands.SEGMENT_D_2.strand;
            strand.setFlow(getFlow(LightStrands.SEGMENT_D_2));
			strand = (Segment) LightStrands.SEGMENT_D_BRANCH_1.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_D_BRANCH_1));
			strand = (Segment) LightStrands.SEGMENT_D_BRANCH_2.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_D_BRANCH_2));
			strand = (Segment) LightStrands.SEGMENT_D_BRANCH_3.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_D_BRANCH_3));
		}

		if ((float) SimInfo.trE > OFF_THRESHOLD) {
			final Segment strand = (Segment) LightStrands.SEGMENT_E.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_E));
		}

		if ((float) SimInfo.trF > OFF_THRESHOLD) {
			Segment strand = (Segment) LightStrands.SEGMENT_F.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_F));
            strand = (Segment) LightStrands.SEGMENT_F_2.strand;
            strand.setFlow(getFlow(LightStrands.SEGMENT_F_2));
			strand = (Segment) LightStrands.SEGMENT_F_BRANCH_1.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_F_BRANCH_1));
			strand = (Segment) LightStrands.SEGMENT_F_BRANCH_2.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_F_BRANCH_2));
			strand = (Segment) LightStrands.SEGMENT_F_BRANCH_3.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_F_BRANCH_3));
		}

		if ((float) SimInfo.trG > OFF_THRESHOLD) {
			final Segment strand = (Segment) LightStrands.SEGMENT_G.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_G));
		}

		if ((float) SimInfo.trH > OFF_THRESHOLD) {
			Segment strand = (Segment) LightStrands.SEGMENT_H.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_H));
			strand = (Segment) LightStrands.SEGMENT_H_BRANCH_1.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_H_BRANCH_1));
			strand = (Segment) LightStrands.SEGMENT_H_BRANCH_2.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_H_BRANCH_2));
		}

		if ((float) SimInfo.trI > OFF_THRESHOLD) {
			final Segment strand = (Segment) LightStrands.SEGMENT_I.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_I));
		}

		if ((float) SimInfo.trJ > OFF_THRESHOLD) {
			Segment strand = (Segment) LightStrands.SEGMENT_J.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_J));
			strand = (Segment) LightStrands.SEGMENT_J_BRANCH_1.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_J_BRANCH_1));
			strand = (Segment) LightStrands.SEGMENT_J_BRANCH_2.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_J_BRANCH_2));
		}

		if ((float) SimInfo.trK > OFF_THRESHOLD) {
			final Segment strand = (Segment) LightStrands.SEGMENT_K.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_K));
		}

		if ((float) SimInfo.trL > OFF_THRESHOLD) {
			Segment strand = (Segment) LightStrands.SEGMENT_L.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_L));
			strand = (Segment) LightStrands.SEGMENT_L_BRANCH_1.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_L_BRANCH_1));
			strand = (Segment) LightStrands.SEGMENT_L_BRANCH_2.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_L_BRANCH_2));
		}

		if ((float) SimInfo.trM > OFF_THRESHOLD) {
			final float flow = (float) SimInfo.trM * amount;
			final float greenFlow = (float) (SimInfo.PowPlant + SimInfo.WindTurbines)
					* (float) (SimInfo.trM / (SimInfo.trA + SimInfo.trM + SimInfo.BatteryStorage * SimInfo.GenScale))
					* amount * (float) SimInfo.GenScale;
			final float blueFlow = flow - greenFlow;

			final Segment strand = (Segment) LightStrands.SEGMENT_M.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_M));

			final int type = strand.advance(blueFlow, greenFlow);
			final OrbTypes orbType;
			if (type == 2) {
				orbType = OrbTypes.GREEN;
			} else {
				orbType = OrbTypes.BLUE;
			}

			if (type > 0) {
				orbs.add(new Orb(orbType, strand, strand.getLEDs().get(0),
						strand.getLEDs().get(1)));
			}
		}

		if (SimInfo.PowPlant + SimInfo.BatteryStorage > 0.0) {
			final float flow = ((float) SimInfo.PowPlant + (float) SimInfo.BatteryStorage) * amount
                    * (float) SimInfo.GenScale;
			final float greenFlow = ((float) SimInfo.PowPlant + (float) SimInfo.BatteryStorage) * amount
                    * (float) SimInfo.GenScale;
			final float blueFlow = flow - greenFlow;

			final Segment strand = (Segment) LightStrands.SEGMENT_W.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_W));

			final int type = strand.advance(blueFlow, greenFlow);
			final OrbTypes orbType;
			if (type == 2) {
				orbType = OrbTypes.GREEN;
			} else {
				orbType = OrbTypes.BLUE;
			}

			if (type > 0) {
				orbs.add(new Orb(orbType, strand, strand.getLEDs().get(0),
						strand.getLEDs().get(1)));
			}
		} else {
            final float flow = -((float) SimInfo.PowPlant + (float) SimInfo.BatteryStorage) * amount
                    * (float) SimInfo.GenScale;
            final float greenFlow = 0f;
            final float blueFlow = flow - greenFlow;

            final Segment strand = (Segment) LightStrands.SEGMENT_W.strand;
            strand.setFlow(getFlow(LightStrands.SEGMENT_W));

            final int type = strand.advance(blueFlow, greenFlow);
            final OrbTypes orbType;
            if (type == 2) {
                orbType = OrbTypes.GREEN;
            } else {
                orbType = OrbTypes.BLUE;
            }

            if (type > 0) {
                Orb orb = new Orb(orbType, strand, strand.getLEDs().get(
                        strand.getLEDs().size() - 1), strand.getLEDs().get(
                        strand.getLEDs().size() - 2));
                orb.forward = false;
                orbs.add(orb);
            }
        }

		if ((float) SimInfo.WindTurbines * (float) SimInfo.GenScale > OFF_THRESHOLD) {
			final float flow = (float) SimInfo.WindTurbines * amount
                    * (float) SimInfo.GenScale;
			final float greenFlow = (float) SimInfo.WindTurbines * amount
                    * (float) SimInfo.GenScale;
			final float blueFlow = flow - greenFlow;

			final Segment strand = (Segment) LightStrands.SEGMENT_X.strand;
			strand.setFlow(getFlow(LightStrands.SEGMENT_X));

			final int type = strand.advance(blueFlow, greenFlow);
			final OrbTypes orbType;
			if (type == 2) {
				orbType = OrbTypes.GREEN;
			} else {
				orbType = OrbTypes.BLUE;
			}

			if (type > 0) {
				orbs.add(new Orb(orbType, strand, strand.getLEDs().get(0),
						strand.getLEDs().get(1)));
			}
		}

		if ((float) SimInfo.trB > OFF_THRESHOLD && SimInfo.Load1 < 0.0) {
			final float greenFlow = (float) SimInfo.trB * amount;

			final int dir = Junctions.B_GEN.advance(1f + jitter(),
					1f + jitter(), 1f + jitter());
			final Segment strand;
			if (dir == 1) {
				strand = (Segment) LightStrands.SEGMENT_B_BRANCH_1.strand;
			} else if (dir == 2) {
				strand = (Segment) LightStrands.SEGMENT_B_BRANCH_2.strand;
			} else {
				strand = (Segment) LightStrands.SEGMENT_B_BRANCH_3.strand;
			}

			final int type = strand.advance(0f, greenFlow);
			final OrbTypes orbType;
			if (type == 2) {
				orbType = OrbTypes.GREEN;
			} else {
				orbType = OrbTypes.BLUE;
			}

			if (type > 0) {
				Orb orb = new Orb(orbType, strand, strand.getLEDs().get(
						strand.getLEDs().size() - 1), strand.getLEDs().get(
						strand.getLEDs().size() - 2));
				orb.forward = false;
				orbs.add(orb);
			}
		}

		if ((float) SimInfo.trD > OFF_THRESHOLD && SimInfo.Load2 < 0.0) {
			final float greenFlow = (float) SimInfo.trD * amount;

			final int dir = Junctions.D_GEN.advance(1f + jitter(),
					1f + jitter(), 1f + jitter());
			final Segment strand;
			if (dir == 1) {
				strand = (Segment) LightStrands.SEGMENT_D_BRANCH_1.strand;
			} else if (dir == 2) {
				strand = (Segment) LightStrands.SEGMENT_D_BRANCH_2.strand;
			} else {
				strand = (Segment) LightStrands.SEGMENT_D_BRANCH_3.strand;
			}

			final int type = strand.advance(0f, greenFlow);
			final OrbTypes orbType;
			if (type == 2) {
				orbType = OrbTypes.GREEN;
			} else {
				orbType = OrbTypes.BLUE;
			}

			if (type > 0) {
				Orb orb = new Orb(orbType, strand, strand.getLEDs().get(
						strand.getLEDs().size() - 1), strand.getLEDs().get(
						strand.getLEDs().size() - 2));
				orb.forward = false;
				orbs.add(orb);
			}
		}

		if ((float) SimInfo.trF > OFF_THRESHOLD && SimInfo.Load3 < 0.0) {
			final float greenFlow = (float) SimInfo.trB * amount;

			final int dir = Junctions.F_GEN.advance(1f + jitter(),
					1f + jitter(), 1f + jitter());
			final Segment strand;
			if (dir == 1) {
				strand = (Segment) LightStrands.SEGMENT_F_BRANCH_1.strand;
			} else if (dir == 2) {
				strand = (Segment) LightStrands.SEGMENT_F_BRANCH_2.strand;
			} else {
				strand = (Segment) LightStrands.SEGMENT_F_BRANCH_3.strand;
			}

			final int type = strand.advance(0f, greenFlow);
			final OrbTypes orbType;
			if (type == 2) {
				orbType = OrbTypes.GREEN;
			} else {
				orbType = OrbTypes.BLUE;
			}

			if (type > 0) {
				Orb orb = new Orb(orbType, strand, strand.getLEDs().get(
						strand.getLEDs().size() - 1), strand.getLEDs().get(
						strand.getLEDs().size() - 2));
				orb.forward = false;
				orbs.add(orb);
			}
		}

		if ((float) SimInfo.trH > OFF_THRESHOLD && SimInfo.Load4 < 0.0) {
			final float greenFlow = (float) SimInfo.trH * amount;

			final int dir = Junctions.H_GEN.advance(1f + jitter(),
					1f + jitter(), 0f);
			final Segment strand;
			if (dir == 1) {
				strand = (Segment) LightStrands.SEGMENT_H_BRANCH_1.strand;
			} else {
				strand = (Segment) LightStrands.SEGMENT_H_BRANCH_2.strand;
			}

			final int type = strand.advance(0f, greenFlow);
			final OrbTypes orbType;
			if (type == 2) {
				orbType = OrbTypes.GREEN;
			} else {
				orbType = OrbTypes.BLUE;
			}

			if (type > 0) {
				Orb orb = new Orb(orbType, strand, strand.getLEDs().get(
						strand.getLEDs().size() - 1), strand.getLEDs().get(
						strand.getLEDs().size() - 2));
				orb.forward = false;
				orbs.add(orb);
			}
		}

		if ((float) SimInfo.trJ > OFF_THRESHOLD && SimInfo.Load5 < 0.0) {
			final float greenFlow = (float) SimInfo.trJ * amount;

			final int dir = Junctions.J_GEN.advance(1f + jitter(),
					1f + jitter(), 0f);
			final Segment strand;
			if (dir == 1) {
				strand = (Segment) LightStrands.SEGMENT_J_BRANCH_1.strand;
			} else {
				strand = (Segment) LightStrands.SEGMENT_J_BRANCH_2.strand;
			}

			final int type = strand.advance(0f, greenFlow);
			final OrbTypes orbType;
			if (type == 2) {
				orbType = OrbTypes.GREEN;
			} else {
				orbType = OrbTypes.BLUE;
			}

			if (type > 0) {
				Orb orb = new Orb(orbType, strand, strand.getLEDs().get(
						strand.getLEDs().size() - 1), strand.getLEDs().get(
						strand.getLEDs().size() - 2));
				orb.forward = false;
				orbs.add(orb);
			}
		}

		if ((float) SimInfo.trL > OFF_THRESHOLD && SimInfo.Load6 < 0.0) {
			final float greenFlow = (float) SimInfo.trL * amount;

			final int dir = Junctions.L_GEN.advance(1f + jitter(),
					1f + jitter(), 0f);
			final Segment strand;
			if (dir == 1) {
				strand = (Segment) LightStrands.SEGMENT_L_BRANCH_1.strand;
			} else {
				strand = (Segment) LightStrands.SEGMENT_L_BRANCH_2.strand;
			}

			final int type = strand.advance(0f, greenFlow);
			final OrbTypes orbType;
			if (type == 2) {
				orbType = OrbTypes.GREEN;
			} else {
				orbType = OrbTypes.BLUE;
			}

			if (type > 0) {
				Orb orb = new Orb(orbType, strand, strand.getLEDs().get(
						strand.getLEDs().size() - 1), strand.getLEDs().get(
						strand.getLEDs().size() - 2));
				orb.forward = false;
				orbs.add(orb);
			}
		}
	}

    private float getFlow(final LightStrands strand) {
        double flow = 0.0;
        switch (strand) {
            case SEGMENT_A: {
                flow = SimInfo.trA;
                break;
            }
            case SEGMENT_B: {
                flow = SimInfo.trB;
                if (SimInfo.Load1 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_B_BRANCH_1:
            case SEGMENT_B_BRANCH_2:
            case SEGMENT_B_BRANCH_3: {
                flow = SimInfo.trB / 3.0;
                if (SimInfo.Load1 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_C: {
                flow = SimInfo.trC;
                if (SimInfo.trA + SimInfo.trB < SimInfo.trD + SimInfo.trE) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_D: {
                flow = SimInfo.trD;
                if (SimInfo.Load2 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_D_2: {
                flow = SimInfo.trD * 2.0 / 3.0;
                if (SimInfo.Load2 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_D_BRANCH_1:
            case SEGMENT_D_BRANCH_2:
            case SEGMENT_D_BRANCH_3: {
                flow = SimInfo.trD / 3.0;
                if (SimInfo.Load2 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_E: {
                flow = SimInfo.trE;
                if (SimInfo.trC + SimInfo.trD < SimInfo.trF + SimInfo.trG) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_F: {
                flow = SimInfo.trF;
                if (SimInfo.Load3 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_F_2: {
                flow = SimInfo.trF * 2.0 / 3.0;
                if (SimInfo.Load3 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_F_BRANCH_1:
            case SEGMENT_F_BRANCH_2:
            case SEGMENT_F_BRANCH_3: {
                flow = SimInfo.trF / 3.0;
                if (SimInfo.Load3 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_G: {
                flow = SimInfo.trG;
                if (SimInfo.trE + SimInfo.trF < SimInfo.trH + SimInfo.trI) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_H: {
                flow = SimInfo.trH;
                if (SimInfo.Load4 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_H_BRANCH_1:
            case SEGMENT_H_BRANCH_2: {
                flow = SimInfo.trH / 2.0;
                if (SimInfo.Load4 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_I: {
                flow = SimInfo.trI;
                if (SimInfo.trK + SimInfo.trJ < SimInfo.trH + SimInfo.trG) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_J:{
                flow = SimInfo.trJ;
                if (SimInfo.Load5 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_J_BRANCH_1:
            case SEGMENT_J_BRANCH_2: {
                flow = SimInfo.trJ / 2.0;
                if (SimInfo.Load5 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_K: {
                flow = SimInfo.trK;
                if (SimInfo.trM + SimInfo.trL < SimInfo.trJ + SimInfo.trI) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_L: {
                flow = SimInfo.trL;
                if (SimInfo.Load6 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_L_BRANCH_1:
            case SEGMENT_L_BRANCH_2: {
                flow = SimInfo.trL / 2.0;
                if (SimInfo.Load6 < 0.0) {
                    flow *= -1.0;
                }
                break;
            }
            case SEGMENT_M: {
                flow = SimInfo.trM;
                break;
            }
            case SEGMENT_W: {
                flow = (SimInfo.PowPlant + SimInfo.BatteryStorage) * SimInfo.GenScale;
                break;
            }
            case SEGMENT_X: {
                flow = SimInfo.WindTurbines * SimInfo.GenScale;
                break;
            }
            default:
        }
        return (float) flow;
    }
}
