package com.example.e03builduiwithlayouteditor2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    val firstnames = arrayOf("Renato", "Rosangela", "Tim", "Bartol", "Jeannette")
    val lastnames = arrayOf("Ksenia", "Metzli", "Asuncion", "Zemfina", "Giang")
    val jobtitles = arrayOf("District Quality Coordinator","International Intranet Representative","District Intranet Administrator","Dynamic Research Manager","Central Infrastructure Consultant")
    val descriptions = arrayOf("a visionary graphic designer renowned for her gift of transforming concepts into captivating visual narratives. With a meticulous attention to detail and an unbridled creative spirit, Ksenia consistently delivers striking designs that leave a lasting impact. Her unique ability to craft visual experiences that resonate with audiences has elevated numerous brands, setting new standards for design excellence.", "a healthcare luminary whose exceptional dedication to patient welfare has earned her recognition in the industry. Her background in nursing has honed her innate ability to provide compassionate care, and she goes above and beyond to ensure the well-being of those under her charge. Metzli's unwavering commitment to improving healthcare outcomes has established her as a paragon of excellence in the field.", "a forward-thinking software engineer who thrives on pushing technological boundaries. Armed with a profound expertise in machine learning and a history of delivering robust solutions, Tim consistently takes on intricate technical challenges and leads projects to triumphant fruition. His unwavering commitment to staying at the forefront of innovation sets him apart in the software development landscape, making him a sought-after professional for ventures seeking to harness the power of cutting-edge technology.", "an accomplished financial analyst whose analytical prowess and meticulous financial modeling are highly regarded in the industry. Armed with a deep understanding of market dynamics and a knack for data-driven decision-making, Bartol plays an indispensable role in optimizing financial strategies. His ability to distill complex financial data into actionable insights is a testament to his expertise and contributes significantly to the success of his clients.", "a dynamic marketing strategist who possesses a unique blend of analytical acumen and creative flair. Her impressive track record of propelling business growth through innovative campaigns speaks to her exceptional talent. With an innate understanding of consumer behavior and a knack for crafting compelling narratives, Jeannette is instrumental in shaping brands, expanding market presence, and achieving impressive ROI for her clients.")
    fun showEmployeeData(index: Int) {
        // find TextView's from the UI layout file
        val firstnameTextView = findViewById<TextView>(R.id.firstnameTextView)
        val lastnameTextView = findViewById<TextView>(R.id.lastnameTextView)
        val jobtitleTextView = findViewById<TextView>(R.id.jobtitleTextView)
        val employeeInfoTextView = findViewById<TextView>(R.id.employeeInfoTextView)
        // Update TextView texts
        firstnameTextView.text = firstnames[index];
        lastnameTextView.text = lastnames[index];
        jobtitleTextView.text = jobtitles[index];

        // info is
        employeeInfoTextView.text = getString(R.string.employee_info_text, lastnames[index], firstnames[index], descriptions[index])

        // image
        var id = 0;
        when(index) {
            0 -> id = R.drawable.employee1
            1 -> id = R.drawable.employee2
            2 -> id = R.drawable.employee3
            3 -> id = R.drawable.employee4
            4 -> id = R.drawable.employee5
        }
        // find imageView and display correct employee image
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(id)
    }
    fun numberClicked(view: View?) {
        val text = (view as TextView).text.toString()
        val int = text.toInt() - 1
        showEmployeeData(int)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showEmployeeData(0)
    }
}

