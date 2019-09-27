/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.alfonz.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A generic ViewHolder that wraps a generated ViewDataBinding class.
 *
 * @param <T> The type of the ViewDataBinding class
 */
public class BaseDataBoundRecyclerViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
	@NonNull public final T binding;

	public BaseDataBoundRecyclerViewHolder(@NonNull T binding) {
		super(binding.getRoot());
		this.binding = binding;
	}

	/**
	 * Creates a new ViewHolder for the given layout file.
	 * <p>
	 * The provided layout must be using data binding.
	 *
	 * @param inflater The LayoutInflater
	 * @param parent The RecyclerView
	 * @param layoutId The layout id that should be inflated. Must use data binding
	 * @param <T> The type of the Binding class that will be generated for the <code>layoutId</code>.
	 * @return A new ViewHolder that has a reference to the binding class
	 */
	@NonNull
	public static <T extends ViewDataBinding> BaseDataBoundRecyclerViewHolder<T> create(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, @LayoutRes int layoutId) {
		T binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
		return new BaseDataBoundRecyclerViewHolder<>(binding);
	}

	/**
	 * Creates a new ViewHolder for the given layout file.
	 * <p>
	 * The provided layout must be using data binding.
	 *
	 * @param lifecycleOwner The LifecycleOwner
	 * @param inflater The LayoutInflater
	 * @param parent The RecyclerView
	 * @param layoutId The layout id that should be inflated. Must use data binding
	 * @param <T> The type of the Binding class that will be generated for the <code>layoutId</code>.
	 * @return A new ViewHolder that has a reference to the binding class
	 */
	@NonNull
	public static <T extends ViewDataBinding> BaseDataBoundRecyclerViewHolder<T> create(@NonNull LifecycleOwner lifecycleOwner, @NonNull LayoutInflater inflater, @NonNull ViewGroup parent, @LayoutRes int layoutId) {
		T binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
		binding.setLifecycleOwner(lifecycleOwner);
		return new BaseDataBoundRecyclerViewHolder<>(binding);
	}
}
