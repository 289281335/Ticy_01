package com.sunmnet.bigdata.web.model.request.predict;

import com.sunmnet.bigdata.commons.model.request.PageREQ;

public class PagePredictFailSubjectREQ extends PageREQ{
    private PredictFailSubjectREQ predictFailSubjectREQ;

    public PredictFailSubjectREQ getPredictFailSubjectREQ() {
        return predictFailSubjectREQ;
    }

    public void setPredictFailSubjectREQ(PredictFailSubjectREQ predictFailSubjectREQ) {
        this.predictFailSubjectREQ = predictFailSubjectREQ;
    }
}
