import { createAsyncThunk, createSlice, PayloadAction } from "@reduxjs/toolkit";
import { RootState, AppThunk } from '../../app/store';
import { fetchCount } from "./counterApi";

export interface CounterState {
    value: number;
    status: 'idle' | 'loading' | 'failed';
}

const initialState: CounterState = {
    value: 0,
    status: 'idle',
};

/* The function below is called a thunk and allow us to perform async logic. 
It can be dispatched like a regular action: 'dispatch(incrementAsync(10))'. 
This will call the thunk with the 'dispatch' function as the first argument. Async
code can then be executed and other actions can be dispatched. Thunks are typically used
to make async requests. 
 */
export const incrementAsync = createAsyncThunk(
    'counter/fetchCount',
    async (amount: number) => {
        const response = await fetchCount(amount);
        // The value we return becomes the 'fulfilled' action payload
        return response.data;
    }
);

export const counterSlice = createSlice({
    name: 'counter',
    initialState,
    // The 'reducers' field lets us define reducers and generate associated actions
    reducers: {
        increment: (state) => {
            /* Redux toolkit allows us to write "mutating" logic in reducers. 
            It doesn't actually mutate the state because it uses the Immer library,
            which detects changes to a "draft state" and produces a brand new 
            immutable state based off those changes.
            */
            state.value += 1;
        },

        decrement: (state) => {
            state.value -= 1;
        },

        incrementByAmount: (state, action: PayloadAction<number>) => {
            state.value += action.payload;
        },
    },

    extraReducers: (builder) => {
        builder
            .addCase(incrementAsync.pending, (state) => {
                state.status= 'loading';
            })
            .addCase(incrementAsync.fulfilled, (state, action) => {
                state.status = 'idle';
                state.value += action.payload;
            })
            .addCase(incrementAsync.rejected, (state) => {
                state.status = 'failed';
            });
    },
});

export const { increment, decrement, incrementByAmount } = counterSlice.actions;

export const selectCount = (state: RootState) => state.counter.value;

export const incrementIfOdd = 
    (amount: number): AppThunk =>
    (dispatch, getState) => {
        const currentValue = selectCount(getState());
        if (currentValue % 2 === 1) {
            dispatch(incrementByAmount(amount));
        }
    };

export default counterSlice.reducer;