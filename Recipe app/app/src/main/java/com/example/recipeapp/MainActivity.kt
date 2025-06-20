package com.example.recipeapp
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerRecipe: Spinner
    private lateinit var spinnerMealPlanner: Spinner
    private lateinit var btnSuggest: Button
    private lateinit var tvSuggestedMeal: TextView

    private var selectedRecipe: String? = null
    private var selectedMealPlanner: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerRecipe = findViewById(R.id.spinnerRecipe)
        spinnerMealPlanner = findViewById(R.id.spinnerMealPlanner)
        btnSuggest = findViewById(R.id.btnSuggest)
        tvSuggestedMeal = findViewById(R.id.tvSuggestedMeal)

        // Expanded data for spinners
        val recipes = arrayOf(
            "Shrimp Scampi", "Eggplant Parmesan", "Moroccan Tagine", "Falafel Wrap",
            "Stuffed Bell Peppers", "Lamb Kofta", "Tacos", "Gazpacho",
            "Pesto Penne", "BBQ Ribs", "French Onion Soup", "Chocolate Mousse"
        )

        val mealPlanners = arrayOf(
            "Picnic", "Potluck", "Buffet", "Barbecue",
            "Tea Time", "Midnight Snack", "Happy Hour", "Tasting Menu",
            "Holiday Feast", "Tapas", "Street Food", "Chef's Special"
        )

        val recipeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, recipes)
        recipeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerRecipe.adapter = recipeAdapter

        val mealPlannerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mealPlanners)
        mealPlannerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMealPlanner.adapter = mealPlannerAdapter

        // Set listeners for spinners
        spinnerRecipe.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedRecipe = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        spinnerMealPlanner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedMealPlanner = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // Set click listener for the button
        btnSuggest.setOnClickListener {
            suggestMeal()
        }
    }

    private fun suggestMeal() {
        val suggestedMeal = "Suggested Meal: $selectedRecipe for $selectedMealPlanner"
        tvSuggestedMeal.text = suggestedMeal
    }
}
