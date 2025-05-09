package com.example.agilelifemanagement.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.agilelifemanagement.ui.screens.calendar.CalendarScreen
import com.example.agilelifemanagement.ui.screens.dailycheckup.DailyCheckupScreen
import com.example.agilelifemanagement.ui.screens.goals.GoalsScreen
import com.example.agilelifemanagement.ui.screens.settings.SettingsScreen
import com.example.agilelifemanagement.ui.screens.sprintreview.SprintReviewScreen
import com.example.agilelifemanagement.ui.screens.sprints.SprintsScreen
import com.example.agilelifemanagement.ui.screens.tasks.TasksScreen

/**
 * Main navigation host for the Agile Life Management app.
 * Defines the navigation graph and routes to all screens.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.CALENDAR,
        modifier = modifier
    ) {
        // Calendar Screen
        composable(route = NavRoutes.CALENDAR) {
            CalendarScreen()
        }
        
        // Sprints Screen and Detail
        composable(route = NavRoutes.SPRINTS) {
            SprintsScreen(
                navigateToSprintDetail = { sprintId ->
                    navController.navigate(NavRoutes.sprintDetail(sprintId))
                }
            )
        }
        
        composable(
            route = NavRoutes.sprintDetail(),
            arguments = listOf(
                navArgument(NavRoutes.SPRINT_ID_ARG) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val sprintId = backStackEntry.arguments?.getString(NavRoutes.SPRINT_ID_ARG) ?: ""
            // SprintDetailScreen(sprintId = sprintId, onNavigateUp = { navController.navigateUp() })
            // Placeholder for Sprint Detail Screen
        }
        
        // Goals Screen and Detail
        composable(route = NavRoutes.GOALS) {
            GoalsScreen(
                navigateToGoalDetail = { goalId ->
                    navController.navigate(NavRoutes.goalDetail(goalId))
                }
            )
        }
        
        composable(
            route = NavRoutes.goalDetail(),
            arguments = listOf(
                navArgument(NavRoutes.GOAL_ID_ARG) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val goalId = backStackEntry.arguments?.getString(NavRoutes.GOAL_ID_ARG) ?: ""
            // GoalDetailScreen(goalId = goalId, onNavigateUp = { navController.navigateUp() })
            // Placeholder for Goal Detail Screen
        }
        
        // Tasks Screen and Detail
        composable(route = NavRoutes.TASKS) {
            TasksScreen(
                navigateToTaskDetail = { taskId ->
                    navController.navigate(NavRoutes.taskDetail(taskId))
                }
            )
        }
        
        composable(
            route = NavRoutes.taskDetail(),
            arguments = listOf(
                navArgument(NavRoutes.TASK_ID_ARG) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString(NavRoutes.TASK_ID_ARG) ?: ""
            // TaskDetailScreen(taskId = taskId, onNavigateUp = { navController.navigateUp() })
            // Placeholder for Task Detail Screen
        }
        
        // Daily Check-up Screen
        composable(route = NavRoutes.DAILY_CHECKUP) {
            DailyCheckupScreen()
        }
        
        // Sprint Review Screen
        composable(route = NavRoutes.SPRINT_REVIEW) {
            SprintReviewScreen()
        }
        
        // Settings Screen
        composable(route = NavRoutes.SETTINGS) {
            SettingsScreen()
        }
    }
}
