package com.example.truecitizenquiz;

public class Questions {
    private int answerresid;
    private boolean answertrue;
    public Questions(int answerresid, boolean answertrue) {
        this.answerresid = answerresid;
        this.answertrue = answertrue;
    }

    public int getAnswerresid() {
        return answerresid;
    }

    public void setAnswerresid(int answerresid) {
        this.answerresid = answerresid;
    }

    public boolean isAnswertrue() {
        return answertrue;
    }

    public void setAnswertrue(boolean answertrue) {
        this.answertrue = answertrue;
    }
}
