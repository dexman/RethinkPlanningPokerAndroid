package com.rethinkbooks.rethinkplanningpoker;


public class Card {

    public final int smallFaceResId;
    public final int largeFaceResId;

    public Card(int smallFaceResId, int largeFaceResId) {
        this.smallFaceResId = smallFaceResId;
        this.largeFaceResId = largeFaceResId;
    }

    public static Card[] loadCards() {
        return new Card[] {
            new Card(R.drawable.small_face_00, R.drawable.large_face_00),
            new Card(R.drawable.small_face_1_2, R.drawable.large_face_1_2),
            new Card(R.drawable.small_face_01, R.drawable.large_face_01),
            new Card(R.drawable.small_face_02, R.drawable.large_face_02),
            new Card(R.drawable.small_face_03, R.drawable.large_face_03),
            new Card(R.drawable.small_face_05, R.drawable.large_face_05),
            new Card(R.drawable.small_face_08, R.drawable.large_face_08),
            new Card(R.drawable.small_face_13, R.drawable.large_face_13),
            new Card(R.drawable.small_face_xx, R.drawable.large_face_xx),
        };
    }

}
