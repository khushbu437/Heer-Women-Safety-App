package com.android.sheguard.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.sheguard.R;
import com.android.sheguard.databinding.FragmentSafetyTipsBinding;
import com.android.sheguard.ui.adapter.SafetyTipsAdapter;

import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class SafetyTipsFragment extends Fragment {

    private final ArrayList<String> safetyTips = new ArrayList<>();
    private FragmentSafetyTipsBinding binding;
    private SafetyTipsAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSafetyTipsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ((AppCompatActivity) requireActivity()).setSupportActionBar(binding.header.toolbar);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            binding.header.collapsingToolbar.setTitle(getString(R.string.activity_safety_tips_title));
            binding.header.collapsingToolbar.setSubtitle(getString(R.string.activity_safety_tips_desc));
        }

        safetyTips.add("Always be aware of your surroundings and trust your instincts.");
        safetyTips.add("Avoid walking alone in poorly lit or secluded areas, especially at night.");
        safetyTips.add("Keep important emergency contacts programmed into your phone for quick access.");
        safetyTips.add("Practice assertive communication to clearly convey your boundaries.");
        safetyTips.add("Consider taking self-defense classes to learn major techniques like striking vulnerable areas, escaping grabs, and basic defense postures.");
        safetyTips.add("Stay connected with friends and family, regularly checking in with them.");
        safetyTips.add("Secure your home with sturdy locks and consider investing in a security system.");
        safetyTips.add("Avoid establishing predictable routines that could make you a target for potential threats.");
        safetyTips.add("Stay sober and avoid excessive alcohol consumption, especially in unfamiliar environments.");
        safetyTips.add("Use safety apps that allow you to quickly alert emergency contacts or authorities, but remember, your safety is paramount.");
        safetyTips.add("When possible, travel with trusted companions, especially during late hours.");
        safetyTips.add("Vary your routes and avoid taking shortcuts through unfamiliar or isolated areas.");
        safetyTips.add("Be cautious when interacting with strangers, especially in situations where you feel uncomfortable.");
        safetyTips.add("Trustworthy companions: consider joining neighborhood watch groups or community safety programs.");
        safetyTips.add("Take care while living alone by staying vigilant and ensuring your home security measures are in place.");

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new SafetyTipsAdapter(requireContext(), safetyTips);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        return view;
    }
}
