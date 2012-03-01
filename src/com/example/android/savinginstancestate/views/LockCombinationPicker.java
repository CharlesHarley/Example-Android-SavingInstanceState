package com.example.android.savinginstancestate.views;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.example.android.savinginstancestate.R;

public class LockCombinationPicker extends LinearLayout {

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;

    public LockCombinationPicker(Context context) {
        this(context, null);
    }

    public LockCombinationPicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LockCombinationPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        loadViews();
    }

    private void loadViews() {
        LayoutInflater.from(getContext()).inflate(R.layout.lock_combination_picker, this, true);

        numberPicker1 = (NumberPicker) findViewById(R.id.number1);
        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(10);

        numberPicker2 = (NumberPicker) findViewById(R.id.number2);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(10);

        numberPicker3 = (NumberPicker) findViewById(R.id.number3);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(10);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        return new SavedState(superState, numberPicker1.getValue(), numberPicker2.getValue(), numberPicker3.getValue());
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        
        numberPicker1.setValue(savedState.getNumber1());
        numberPicker2.setValue(savedState.getNumber2());
        numberPicker3.setValue(savedState.getNumber3());
    }

    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        // As we save our own instance state, ensure our children don't save and restore their state as well.
        super.dispatchFreezeSelfOnly(container);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        /** See comment in {@link #dispatchSaveInstanceState(android.util.SparseArray)}  */
        super.dispatchThawSelfOnly(container);
    }

    /**
     * Convenience class to save / restore the lock combination picker state. Looks clumsy
     * but once created is easy to maintain and use.
     */
    protected static class SavedState extends BaseSavedState {

        private final int number1;
        private final int number2;
        private final int number3;

        private SavedState(Parcelable superState, int number1, int number2, int number3) {
            super(superState);
            this.number1 = number1;
            this.number2 = number2;
            this.number3 = number3;
        }

        private SavedState(Parcel in) {
            super(in);
            number1 = in.readInt();
            number2 = in.readInt();
            number3 = in.readInt();
        }

        public int getNumber1() {
            return number1;
        }

        public int getNumber2() {
            return number2;
        }

        public int getNumber3() {
            return number3;
        }

        @Override
        public void writeToParcel(Parcel destination, int flags) {
            super.writeToParcel(destination, flags);
            destination.writeInt(number1);
            destination.writeInt(number2);
            destination.writeInt(number3);
        }

        public static final Parcelable.Creator<SavedState> CREATOR = new Creator<SavedState>() {

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }

        };

    }

}
